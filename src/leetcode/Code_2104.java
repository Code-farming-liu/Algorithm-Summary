package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_2104 {
    public static long subArrayRanges(int[] nums) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }

    // 区间DP
    // f[l][r][0]=min(f[l][r−1][0],nums[r])
    //
    //f[l][r][1] = max(f[l][r - 1][1], nums[r])
    //f[l][r][1]=max(f[l][r−1][1],nums[r])
    //
    public long subArrayRanges3(int[] nums) {
        int n = nums.length;
        int[][][] f = new int[n][n][2];
        for (int i = 0; i < n; i++) f[i][i][0] = f[i][i][1] = nums[i];
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                f[l][r][0] = Math.min(nums[r], f[l][r - 1][0]);
                f[l][r][1] = Math.max(nums[r], f[l][r - 1][1]);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans += f[i][j][1] - f[i][j][0];
            }
        }
        return ans;
    }

    // 单调栈
    static int n;
    public static long subArrayRanges2(int[] nums) {
        n = nums.length;
        // min[i] 为 nums[i] 作为区间最小值的次数；max[i] 为 nums[i] 作为区间最大值的次数
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (max[i] - min[i]) * nums[i];
        }
        return ans;
    }
    static long[] getCnt(int[] nums, boolean isMin) {
        int[] a = new int[n], b = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] >= nums[i] : nums[d.peekLast()] <= nums[i])) {
                d.pollLast();
            }
            a[i] = d.isEmpty() ? -1 : d.peekLast();
            d.addLast(i);
        }
        d.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!d.isEmpty() && (isMin ? nums[d.peekLast()] > nums[i] : nums[d.peekLast()] < nums[i])) {
                d.pollLast();
            }
            b[i] = d.isEmpty() ? n : d.peekLast();
            d.addLast(i);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) ans[i] = (i - a[i]) * 1L * (b[i] - i);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subArrayRanges2(nums);
    }
}
