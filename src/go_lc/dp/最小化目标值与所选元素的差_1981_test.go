package dp

import "math"

/*
*
给你一个大小为 m x n 的整数矩阵 mat 和一个整数 target 。

从矩阵的 每一行 中选择一个整数，你的目标是 最小化 所有选中元素之 和 与目标值 target 的 绝对差 。

返回 最小的绝对差 。

a 和 b 两数字的 绝对差 是 a - b 的绝对值。

示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], target = 13
输出：0
解释：一种可能的最优选择方案是：
- 第一行选出 1
- 第二行选出 5
- 第三行选出 7
所选元素的和是 13 ，等于目标值，所以绝对差是 0 。
示例 2：

输入：mat = [[1],[2],[3]], target = 100
输出：94
解释：唯一一种选择方案是：
- 第一行选出 1
- 第二行选出 2
- 第三行选出 3
所选元素的和是 6 ，绝对差是 94 。
示例 3：

输入：mat = [[1,2,9,8,7]], target = 6
输出：1
解释：最优的选择方案是选出第一行的 7 。
绝对差是 1 。

提示：

m == mat.length
n == mat[i].length
1 <= m, n <= 70
1 <= mat[i][j] <= 70
1 <= target <= 800
*/
func minimizeTheDifference(mat [][]int, target int) int {
	// dp[i][j] 表示在前 i 行中选择一个元素，使得这些元素的和为 j 是否可能。如果可能，则 dp[i][j] 为 true，否则为 false。
	m, n := len(mat), len(mat[0])
	maxSum := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			maxSum += mat[i][j]
		}
	}

	dp := make([][]bool, m+1)
	for i := range dp {
		dp[i] = make([]bool, maxSum+1)
	}
	for _, num := range mat[0] {
		dp[0][num] = true
	}

	for i := 1; i < m; i++ {
		for j := 0; j <= maxSum; j++ {
			if dp[i-1][j] {
				for _, num := range mat[i] {
					if j+num <= maxSum {
						dp[i][j+num] = true
					}
				}
			}
		}
	}

	minDiff := math.MaxInt32
	for sum := 0; sum <= maxSum; sum++ {
		if dp[m-1][sum] {
			minDiff = min(minDiff, abs(sum-target))
		}
	}
	return minDiff
}
