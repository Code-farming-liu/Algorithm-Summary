package zhenti.baidu;

import java.util.Scanner;

// 度度熊请你找出两个数，满足且尽量大。输出最大的.
//其中表示和的最小公倍数，表示和的最大公约数。
//
//输入描述:
//一行一个数字。
//
//输出描述:
//一行一个数字表示最大的。
//
//输入例子1:
//5
//
//输出例子1:
//19
//
//输入例子2:
//3
//
//输出例子2:
//5
public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(lcm(n - 1, n) - gcd(n - 1, n));
    }

    public static long gcd(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
