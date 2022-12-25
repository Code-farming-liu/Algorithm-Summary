package offer;

/**
 * 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *

 */
public class Code_62 {

    /**
     * https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-by-lee/
     * @param n
     * @param m
     * @return
     */

       /*
    思路：使用数学方法(先举例)
            你要知道最后的结果是3，带着结果去看问题

        第一次，【0, 1, 2, 3, 4】，本轮要踢出2                                  看3
        (下一轮开始从3计数，为了方便读者看出规律，将开始计数的那一位移到开头)
        第二次，【3, 4, 0, 1】，本轮要踢出0                                     看1
        第三次，【1, 3, 4】，本轮要踢出4                                        看1
        第四次，【1, 3】 本轮要踢出1                                            看3
        第五次，【3】
        最后返回3

        我们要使用的数学方法，就是从结果0号位置，反推最开始在哪
        你从第二次，向上看第一次
        你会发现，原来3在0的位置
                现在，3在(0 + 3) % 5
                        => +3 回到上次的位置
                        => %5 防止数组溢出，并且数组本来就是循环数组

        f(n) = ( f(n - 1) + m ) % n
        解释意思：
            f(n) 表示上一次
            f(n - 1) 表示这次，因为我们要从这次回推上一次
            m 表示隔几个
            n表示上一次的数组长度

     */
    // 迭代数学
    public int lastRemaining1(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }


    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n -1, m);
        return (m + x) % n;
    }
}
