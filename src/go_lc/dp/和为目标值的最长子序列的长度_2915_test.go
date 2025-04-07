package dp

import "testing"

/*
给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。

返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。

子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。

示例 1：

输入：nums = [1,2,3,4,5], target = 9
输出：3
解释：总共有 3 个子序列的和为 9 ：[4,5] ，[1,3,5] 和 [2,3,4] 。最长的子序列是 [1,3,5] 和 [2,3,4] 。所以答案为 3 。
示例 2：

输入：nums = [4,1,3,2,1,5], target = 7
输出：4
解释：总共有 5 个子序列的和为 7 ：[4,3] ，[4,1,2] ，[4,2,1] ，[1,1,5] 和 [1,3,2,1] 。最长子序列为 [1,3,2,1] 。所以答案为 4 。
示例 3：

输入：nums = [1,1,5,4,5], target = 3
输出：-1
解释：无法得到和为 3 的子序列。

提示：

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
1 <= target <= 1000
*/
func lengthOfLongestSubsequence1(nums []int, target int) int {
	dp := make([][]int, len(nums)+1)
	for i := range dp {
		dp[i] = make([]int, target+1)
	}

	dp[0][0] = 0
	for j := 1; j < target+1; j++ {
		dp[0][j] = -1
	}

	for i := 1; i <= len(nums); i++ {
		for j := 0; j < target+1; j++ {
			if j >= nums[i-1] && dp[i-1][j-nums[i-1]] != -1 {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-nums[i-1]]+1)
				continue
			}
			dp[i][j] = dp[i-1][j]
		}
	}
	return dp[len(nums)][target]
}

func lengthOfLongestSubsequence(nums []int, target int) int {
	dp := make([]int, target+1)

	dp[0] = 0
	for j := 1; j < target+1; j++ {
		dp[j] = -1
	}

	for i := 1; i <= len(nums); i++ {
		for j := target; j >= nums[i-1]; j-- {
			if dp[j-nums[i-1]] != -1 {
				dp[j] = max(dp[j], dp[j-nums[i-1]]+1)
			}
		}
	}
	return dp[target]
}

func TestLen(t *testing.T) {
	lengthOfLongestSubsequence([]int{1, 2, 3, 4, 5}, 9)
}
