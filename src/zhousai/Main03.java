package zhousai;

import java.util.Arrays;

/**
 * @ClassName: Main03
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/8/29 11:53
 **/

public class Main03 {
    public static void main(String[] args) {
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            int lb = Integer.lowestOneBit(i);
            sum[i] = sum[i - lb] + tasks[Log2.floorLog(lb)];
        }
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            int subset = i + 1;
            dp[i] = (int) 1e9;
            while (subset > 0) {
                subset = (subset - 1) & i;
                if (subset != 0 && sum[subset] <= sessionTime) {
                    dp[i] = Math.min(dp[i], dp[i - subset] + 1);
                }
            }
        }
        boolean dbg = false;
        if (dbg) {
            System.out.println(Arrays.toString(sum));
            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }
}

class Log2 {
    public static int ceilLog(int x) {
        if (x <= 0) {
            return 0;
        }
        return 32 - Integer.numberOfLeadingZeros(x - 1);
    }

    public static int floorLog(int x) {
        if (x <= 0) {
            throw new IllegalArgumentException();
        }
        return 31 - Integer.numberOfLeadingZeros(x);
    }

    public static int ceilLog(long x) {
        if (x <= 0) {
            return 0;
        }
        return 64 - Long.numberOfLeadingZeros(x - 1);
    }

    public static int floorLog(long x) {
        if (x <= 0) {
            throw new IllegalArgumentException();
        }
        return 63 - Long.numberOfLeadingZeros(x);
    }
}