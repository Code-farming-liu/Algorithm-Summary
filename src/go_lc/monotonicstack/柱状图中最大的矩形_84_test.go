package monotonicstack

/*
*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

示例 1:

输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：

输入： heights = [2,4]
输出： 4

提示：

1 <= heights.length <=105
0 <= heights[i] <= 104
*/
func largestRectangleArea(heights []int) int {
	res := 0
	stack := make([]int, 0)
	height := make([]int, len(heights)+2)
	for i := 0; i < len(heights); i++ {
		height[i+1] = heights[i]
	}
	for i, v := range height {
		for len(stack) > 0 && v <= height[stack[len(stack)-1]] { // 单调递减
			h := height[stack[len(stack)-1]]

			w := 0 // 右边第一个比他高的下标 - 左边第一个比他高的下标 - 1
			if len(stack) > 1 {
				w = i - stack[len(stack)-2] - 1
			}
			res = max(res, h*w)
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, i)
	}

	return res
}
