package dp

/**
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

func canPartition(nums []int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	if sum%2 != 0 {
		return false
	}

	target := sum / 2
	dp := make([]int, target+1)
	for i := 0; i < len(nums); i++ {
		for j := target; j >= nums[i]; j-- {
			dp[j] = max(dp[j], dp[j-nums[i]]+nums[i])
		}
	}
	return dp[target] == target
}

func canPartition1(nums []int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}

	if sum%2 != 0 {
		return false
	}

	target := sum / 2
	dp := make([][]int, len(nums)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, target+1)
	}

	// 初始化 dp[0][0] 为 0
	dp[0][0] = 0

	// 初始化 dp[i][0] 为 0
	for i := 0; i < len(nums)+1; i++ {
		dp[i][0] = 0
	}

	// 初始化 dp[0][j] 为 0
	for j := 0; j < target+1; j++ {
		dp[0][j] = 0
	}

	// 遍历每个元素
	for i := 1; i <= len(nums); i++ {
		for j := 0; j <= target; j++ {
			if j >= nums[i-1] {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-nums[i-1]]+nums[i-1])
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	return dp[len(nums)][target] == target
}
