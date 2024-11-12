package leetcode

import "testing"

/**
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
子集
（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
*/

func subsets(nums []int) [][]int {
	resp := [][]int{}
	var dfs func(nums []int, index int, path []int, visit []bool)
	dfs = func(nums []int, index int, path []int, visit []bool) {
		if index == len(nums)+1 {
			return
		}
		newPath := make([]int, len(path))
		copy(newPath, path)
		resp = append(resp, newPath)
		for i := index; i < len(nums); i++ {
			if visit[i] {
				continue
			}
			path = append(path, nums[i])
			visit[i] = true
			dfs(nums, i, path, visit)
			path = path[:len(path)-1]
			visit[i] = false
		}
	}
	dfs(nums, 0, []int{}, make([]bool, len(nums)))
	return resp
}

func TestSu(t *testing.T) {
	nums := []int{1, 2, 3}
	subsets(nums)
}
