package offer;

/**
 * @ClassName: Test11
 * @Description: 二进制中1的个数
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * @Author: Admin
 **/

public class Code_11 {
    /**
     * @param n
     * @Author: Admin
     * @Description: 思路分析：
     * 首先我们先来了解点基础知识，
     * 正数的补码、反码、原码都相等
     * 负数的补码 = 原码取反 + 1
     * 负数的反码 = 原码取反
     * <p>
     * 我们首先先来 看个 例子
     * 3 ------- 0011； 2个1
     * 2 --------0010； 1个1
     * 1 --------0001； 1个1
     * 很容易可以看出 3 等于前两个1的和 如果逆向思维了一下 不难看出
     * 0011 & 0010 = 0010
     * 0010 & 0001 = 0000
     * 最终变为0 因此我们可以使用一个计数器， 统计该值 n & (n - 1)的次数，每次count++,直到该值为0；
     * @return: int
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}