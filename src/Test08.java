/**
 * @ClassName: Test08
 * @Description: 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * @Author: Admin
 * @Date 2020/9/2 17:19
 **/

public class Test08 {
    //使用三个指针
//    public int Fibonacci(int n) {
//        int pre = 1;
//        int next = 1;
//        int res = 0;
//
//        if(n < 0){
//            return 0;
//        } else if (n == 1 || n == 2) {
//            return 1;
//        } else {
//            for(int i = 3; i <= n; i++){
//                res = pre + next;
//                pre = next;
//                next = res;
//            }
//            return res;
//        }
//    }

    //使用数组辅助
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