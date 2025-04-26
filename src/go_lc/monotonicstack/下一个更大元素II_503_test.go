package monotonicstack

import "testing"

/**
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。



示例 1:

输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:

输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]


提示:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
*/

func nextGreaterElements(nums []int) []int {
	n := len(nums)
	res := make([]int, n)
	stack := make([]int, 0)

	for i := range res {
		res[i] = -1
	}
	for i := 0; i < 2*n; i++ {
		v := nums[i%n]
		for len(stack) != 0 && v > nums[stack[len(stack)-1]%n] {
			res[stack[len(stack)-1]%n] = nums[i%n]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}
	return res
}

func TestS(t *testing.T) {
	nums := []int{1, 2, 1}
	nextGreaterElements(nums)
}
