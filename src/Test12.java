/**
 * @ClassName: Test12
 * @Description: 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 * @Author: Admin
 **/

public class Test12 {
    //暴力破解
//    public double myPow(double x, int n) {
//        long N = n;
//        if (N < 0) {
//            x = 1 / x;
//            N = -N;
//        }
//        double ans = 1;
//        for (long i = 0; i < N; i++)
//            ans = ans * x;
//        return ans;
//    }
    //快速幂
    //递归
//    private double fastPow(double x, long n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        double half = fastPow(x, n / 2);
//        if (n % 2 == 0) {
//            return half * half;
//        } else {
//            return half * half * x;
//        }
//    }
//    public double myPow(double x, int n) {
//        long N = n;
//        if (N < 0) {
//            x = 1 / x;
//            N = -N;
//        }
//
//        return fastPow(x, N);
//    }

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