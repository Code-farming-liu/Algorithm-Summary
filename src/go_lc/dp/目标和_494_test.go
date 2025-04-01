package dp

/**
给你一个非负整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。



示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1


提示：

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
*/

func findTargetSumWaysDFS(nums []int, target int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	if sum < target {
		return 0
	}

	res := 0
	var dfs func(nums []int, target int, index int)
	dfs = func(nums []int, target int, index int) {
		if index == len(nums) {
			if target == 0 {
				res++
			}
			return
		}

		dfs(nums, target-nums[index], index+1)
		dfs(nums, target+nums[index], index+1)
	}
	dfs(nums, target, 0)
	return res
}

func findTargetSumWays(nums []int, target int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	if sum < abs(target) {
		return 0
	}

	// 确定dp定义
	// 定义 dp[i][j] 为使用前 i 个数字，得到和为 j 的表达式的数目。
	// 确定递推公式
	// 对于每个数字 nums[i-1]，有两种选择：将其视为正数或负数。
	//如果将其视为正数，则 dp[i][j] += dp[i-1][j-nums[i-1]]。
	//如果将其视为负数，则 dp[i][j] += dp[i-1][j+nums[i-1]]。
	//因此，递推公式为：
	// dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j+nums[i-1]]

	dp := make([][]int, len(nums)+1)
	for i := range dp {
		dp[i] = make([]int, 2*sum+1)
	}
	dp[0][sum] = 1
	for i := 1; i <= len(nums); i++ {
		for j := 0; j <= 2*sum; j++ {
			if j-nums[i-1] >= 0 {
				dp[i][j] += dp[i-1][j-nums[i-1]]
			}

			if j+nums[i-1] <= 2*sum {
				dp[i][j] += dp[i-1][j+nums[i-1]]
			}
		}
	}
	return dp[len(nums)][sum+target]
}

// 辅助函数：计算绝对值
func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
