package leetcode;

/**
 * @ClassName: Code_494
 * @Description: 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 *
 * 输入：nums = [1], target = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * @Author: Admin
 **/

public class Code_494 {
    int res = 0;
    public int findTargetSumWays1(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return res;
    }
    public void dfs(int[] nums, int target, int index, int cur) {
        if (index == nums.length) {
            if (cur == target) {
                res++;
            }
        } else {
            dfs(nums, target, index + 1, cur + nums[index]);
            dfs(nums, target, index + 1, cur - nums[index]);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum) {
            return 0;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int start = (sum + target) / 2;
        int[] dp = new int[start + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = start; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[start];
    }

//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}