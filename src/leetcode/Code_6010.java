package leetcode;

import java.util.Arrays;

public class Code_6010 {
    public static long minimumTime(int[] time, int totalTrips) {
        int[] a = new int[time.length];
        Arrays.fill(a, 1);
        int res = 0;
        Arrays.sort(time);
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < time.length; j++) {
                if (i + 1 < (time[j] * a[j])) {
                    continue;
                }
                a[j]++;
                res++;
            }
            if (res >= totalTrips) {
                return i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] time = {9, 3, 10, 5};
        System.out.println(minimumTime(time, 2)); // 25
    }
}
