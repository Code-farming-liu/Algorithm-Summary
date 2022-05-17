package leetcode;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * <p>
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *  
 * <p>
 * 提示: 
 * <p>
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class Code_673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], res = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        res[i] = res[j];
                    } else if (dp[i] == dp[j] + 1) {
                        res[i] += res[j];

                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans += res[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        Arrays.sort(nums);
    }
}
