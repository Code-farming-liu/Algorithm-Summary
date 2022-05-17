package zhenti.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
//
//        int n = 6;
//        int x = 2;
//        int y = 3;
//        int[] nums = {1, 2, 3, 4, 5, 6};

        Arrays.sort(nums);
        int res = 0;
        int left = x, right = y + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (n - mid - 1 > y) {
                left = mid + 1;
            } else if (n - mid - 1 < x) {
                right = mid;
            } else {
                res = nums[mid];
                right = mid - 1;
            }
        }
        System.out.println(res == 0 ? -1 : res);
    }
}
