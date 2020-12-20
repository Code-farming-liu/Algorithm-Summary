package offer;

/**
 * @ClassName: Test08
 * @Description: 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * @Author: Admin
 **/

public class Code_07 {
    //使用三个指针
    /**
     * @Author: Admin
     * @Description: 思路描述：
     * 我们在此之前先来了解了解什么是斐波那契数列，他的特点：
     * 除了刚开始的两个为1，之后下一位是上两位的和
     *
     * 我们可以用 三个指针分别指向 pre，next，指向相邻的变量，而res为下一个变量 res = pre + next;
     * 然后对应的变换指针，pre = next; next = res;
     * @param n
     * @return: int
     */
    public int Fibonacci1(int n) {
        int pre = 1;
        int next = 1;
        int res = 0;

        if (n < 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                res = pre + next;
                pre = next;
                next = res;
            }
            return res;
        }
    }

    //使用数组辅助
    /**
     * @Author: Admin
     * @Description: 思路描述
     * 我们可以使用数组进行存储，然后指针的位置变换，最终实现斐波那契数列。
     * a[i + 2] = a[i] + a[i + 1];
     * @param n
     * @return: int
     */
    public int Fibonacci(int n) {
        int a[] = new int[n + 3];
        a[0] = 1;
        a[1] = 1;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            a[i + 2] = a[i] + a[i + 1];
        }
        return a[n - 1];
    }

}