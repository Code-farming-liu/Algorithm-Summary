package offer;

/**
 * @ClassName: Test12
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 保证base和exponent不同时为0
 * @Author: Admin
 **/

public class Code_12 {
    //暴力破解

    /**
     * @param x
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 暴力破解（不可取）
     * 只需要讲x 连乘n次，如果是负指数 则 x 变为倒数，n 变为正负即可
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
    //快速幂
    //递归

    /**
     * @param x
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 快速幂
     * 我们可以推导 公式 假定我们已经得到了x ^ n/2的结果，并且我们想要得到x^n的结果。
     * 因此我们令 A = x ^ n/2的结果，我们可以根据 n 的奇偶性来分别讨论 x ^ n的值，
     * 如果n 为 偶数，我们可以用公式 (x ^ n) ^ 2 = x ^ 2 * n来推导出 x ^ n = A * A,
     * 如果 n为奇数，那么 A * A = x ^ n - 1,直观上可以看出来。
     * 我们还需要再去乘一次x,即 x ^ n = A * A * x.该方法可以很方便的使用递归实现
     * <p>
     * 总结：
     * A = x ^ n/2
     * n为偶数 x^n = A * A
     * n为奇数 x^n = A * A * x
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

    //迭代
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