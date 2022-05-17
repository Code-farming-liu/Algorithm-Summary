package zhenti.baidu;

import java.util.Arrays;
import java.util.Scanner;

// 老板给度度熊个数， 每一次从中取出一个最大的减去， 其他的个数加上， 一直重复直到最大的， 执行次数记为。
//老板想知道最少执行多少次操作使得个数都小于呢？
//
//输入描述:
//第一行一个数。
//第二行个数表示数列。
//
//输出描述:
//一个数表示
//
//输入例子1:
//3
//1 0 3
//
//输出例子1:
//1
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        long count = 0L;
        while (!isExist(nums, n)) {
            Arrays.sort(nums);
            count += nums[n - 1] / n;
            for (int i = 0; i < n - 1; i++) {
                nums[i] += nums[n - 1] / n;
            }
            nums[n - 1] = nums[n - 1] % n;
        }
        System.out.println(count);
    }
    
    public static boolean isExist(long[] nums, int n) {
        for (long num : nums) {
            if (num > n) {
                return false;
            }
        }
        return true;
    }
}
