package leetcode

import "testing"

/**
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

子数组 定义为原数组中的一个连续子序列。

请你返回 arr 中 所有奇数长度子数组的和 。



示例 1：

输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
示例 2：

输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
示例 3：

输入：arr = [10,11,12]
输出：66


提示：

1 <= arr.length <= 100
1 <= arr[i] <= 1000


进阶：

你可以设计一个 O(n) 时间复杂度的算法解决此问题吗？
*/

func sumOddLengthSubarrays(arr []int) int {
	pre := make([]int, len(arr))
	sum := 0
	for i := 0; i < len(arr); i++ {
		sum += arr[i]
		pre[i] = sum
	}

	res := 0
	for i := 0; i < len(arr); i++ {
		for j := i; j < len(arr); j += 2 {
			if i > 0 {
				res += pre[j] - pre[i-1]
				continue
			}
			res += pre[j]
		}
	}
	return res
}

func TestSum(t *testing.T) {
	nums := []int{1, 4, 2, 5, 3}
	sumOddLengthSubarrays(nums)
}
