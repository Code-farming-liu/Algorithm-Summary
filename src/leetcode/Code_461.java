package leetcode;

/**
 * @ClassName: Code_461
 * @Description: 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * @Author: Admin
 **/

public class Code_461 {
    public int hammingDistance1(int x, int y) {
        int res = 0;
        int temp = x ^ y;
        String temp1 = Integer.toBinaryString(temp);
        for (int i = 0; i < temp1.length(); i++) {
            if (temp1.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * @Author: Admin
     * @Description:
     * 取某个数中有多少1时，可以使用x &= x - 1快速跳过其中的0
     * @return: null
     */
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }
}