package leetcode;

/**
 * @ClassName: Code_69
 * @Description: X的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * @Author: Admin
 **/

public class Code_69 {
    /**
     * @param x
     * @Author: Admin
     * @Description: 思路描述：
     * 使用对应的公式
     *
     * √x = e ^ 1/ 2 * lnx,但是有可能会有精度的丢失
     *
     * 因此使用一个 值 等于 这个 值 + 1，
     *
     * 因此我们应该找出的是 这个值 还是 这个值 + 1.
     * @return: int
     */
    public int mySqrt(int x) {
        int left = (int) Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long) right * right > x ? left : right;
    }

    /**
     * @param x
     * @Author: Admin
     * @Description: 思路描述：
     * 使用对应的 二分查找法
     *
     * 由于 x 平方根的整数部分，ans 是满足 k^2  <= x的最大的k值，
     * 因此我们可以对 k 进行二分查找，从而得到答案。
     *
     * 二分查找的下界为0 ，上界设定为x
     * @return: int
     */
    public int mySqrt1(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}