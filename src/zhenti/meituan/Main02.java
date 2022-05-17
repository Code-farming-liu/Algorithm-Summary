package zhenti.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int[] temp = new int[n];
        for (int i = 1; i <= n; i++) {
            temp[i - 1] = i;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(nums[i] - temp[i]);
        }
        System.out.println(res);
    }
}
