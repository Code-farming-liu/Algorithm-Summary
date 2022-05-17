package zhenti.ali;

import java.util.Scanner;

// 小强发现当已知以及时,能很轻易的算出的值.但小强想请你在已知 和的情况下,计算出的值.因为这个结果可能很大,所以所有的运算都在模1e9+7下进行.
//
//输入描述:
//第一行输入一个正整数.表示有组数据
//接下来行,每行输入三个整数,和.
//
//
//
//
//输出描述:
//输出行,每一行表示每组数据的结果.
//
//输入例子1:
//3
//4 4 3
//2 3 4
//5 2 6
//
//输出例子1:
//16
//999999993
//9009
public class Main02 {
    static double mod = 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            double a = scanner.nextDouble() % mod;
            double b = scanner.nextDouble() % mod;
            double n = scanner.nextDouble() % mod;
            double pow = Math.pow((a + b), n) % mod;
            for (int i = 1; i < n; i++) {
                pow -= (((help(n) % mod) / ((help(i) % mod) * help(n - i))) * (Math.pow(a, n - i) % mod) * (Math.pow(b, i)) % mod) % mod;
            }
            System.out.println(pow);
            t--;
        }
    }

    public static double help(double n) {
        if (n == 0) {
            return 1;
        }
        return (help(n - 1) % mod) * (n % mod) % mod;
    }
    public static double help(double n, double t) {
        double res = n;
        for (int i = 0; i < t; i++) {
            res *= (n - 1) % mod;
        }
        return res % mod;
    }
}
