package 回溯

/**
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。



示例 1：

输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
示例 2:

输入: nums = [1,2,3,4], k = 3
输出: false


提示：

1 <= k <= len(nums) <= 16
0 < nums[i] < 10000
每个元素的频率在 [1,4] 范围内
*/

func canPartitionKSubsets(nums []int, k int) bool {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if sum%k != 0 {
		return false
	}
	target := sum / k
	var dfs func([]int, int, int, int, []bool) bool
	dfs = func(nums []int, k int, target int, start int, used []bool) bool {
		if k == 0 {
			return true
		}
		if target == 0 {
			return dfs(nums, k-1, target, 0, used)
		}
		for i := start; i < len(nums); i++ {
			if used[i] || nums[i] > target {
				continue
			}
			used[i] = true
			target -= nums[i]
			if dfs(nums, k, target, i+1, used) {
				return true
			}
			target += nums[i]
			used[i] = false
		}
		return false
	}

	return dfs(nums, k, target, 0, make([]bool, len(nums)))
}
