package zhenti.ali;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            long[] x = new long[n];
            long[] y = new long[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextLong();
            }
            for (int i = 0; i < n; i++) {
                y[i] = scanner.nextLong();
            }
            long[][] nums = new long[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = x[i];
                nums[i][1] = y[i];
            }
            Arrays.sort(nums, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return (int) (o1[0] == o2[0] ? o1[2] - o2[1] : o1[0] - o2[0]);
                }
            });
            int res = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = i + 1; j < n; j++) {
                    if (nums[i][1] < nums[j][1]) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
            System.out.println(res);
            t--;
        }
    }
}
