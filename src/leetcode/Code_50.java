package leetcode;

/**
 * @ClassName: Test62
 * @Description: Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * @Author: Admin
 **/

public class Code_50 {
    //暴力

    /**
     * @param x
     * @param n
     * @Author: Admin
     * @Description: 只需要将x 连乘n次，如果是负指数 则 x 变为倒数，n 变正负即可
     * @return: double
     */
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

    //快速幂算法

    /**
     * @param x
     * @param n
     * @Author: Admin
     * @Description: 快速幂
     * 假定我们已经得到 x ^ n / 2次我们将它定义为 A
     * 那么我们可以利用n的奇偶性来判断 x ^ n的值
     * 当 n是偶数时 x^ n = x^ n/ 2 * x^ n/2 = A * A
     * 当n是奇数时 x ^ n + 1 = x^ n/ 2 * x^ n/2 * x = A * A * x
     * 总结来说：
     * A = x ^ n/2 n为偶数 x^n = A * A n为奇数 x^n = A * A * x
     * @return: double
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    //循环的 快速幂算法
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }
}