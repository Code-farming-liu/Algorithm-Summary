package monotonicstack

import "testing"

/**
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9


提示：

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

func trap(height []int) int {
	res := 0
	stack := make([]int, 0)

	for i, v := range height {
		for len(stack) > 0 && v >= height[stack[len(stack)-1]] {
			mid := height[stack[len(stack)-1]]
			right := v
			left := 0 // 单调递增栈，栈中的第二个元素就是左边第一个比它大的元素
			if len(stack) > 1 {
				left = height[stack[len(stack)-2]] // 左边第一个比他大的元素
			}

			h := min(left, right) - mid // 左边第一个比他高的 与右边第一个比他高的取最小值 - 当前元素的高度
			w := 0                      // 右边第一个比他高的下标 - 左边第一个比他高的下标 - 1
			if len(stack) > 1 {
				w = i - stack[len(stack)-2] - 1
			}
			res += h * w
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}

	return res
}

func TestTrap(t *testing.T) {
	nums := []int{60, 20, 20, 10, 30}

	trap(nums)
}
