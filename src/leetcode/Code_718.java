package leetcode;

public class Code_718 {
    // dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最⻓重复⼦数组⻓度为dp[i][j]。
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
