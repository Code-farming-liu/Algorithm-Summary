package dp

/*
*给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

示例 1：

输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9

提示：

1 <= n <= 104
*/
func numSquares2(n int) int {
	squares := []int{}
	for i := 1; i*i <= n; i++ {
		squares = append(squares, i*i)
	}

	dp := make([][]int, len(squares)+1)
	for i := 0; i <= len(squares); i++ {
		dp[i] = make([]int, n+1)
	}
	for i := 0; i <= len(squares); i++ {
		for j := 0; j <= n; j++ {
			dp[i][j] = n + 1
		}
	}
	for i := 0; i <= len(squares); i++ {
		dp[i][0] = 0
	}

	for i := 1; i < len(dp); i++ {
		for j := 1; j <= n; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= squares[i-1] {
				dp[i][j] = min(dp[i-1][j], dp[i][j-squares[i-1]]+1)
			}
		}
	}

	if dp[len(squares)][n] > n {
		return -1
	}

	return dp[len(squares)][n]
}

func numSquares(n int) int {
	squares := []int{}
	for i := 1; i*i <= n; i++ {
		squares = append(squares, i*i)
	}

	dp := make([]int, n+1)

	for i := 0; i < len(dp); i++ {
		dp[i] = n + 1
	}

	dp[0] = 0

	for i := 1; i < len(squares); i++ {
		for j := 1; j <= n; j++ {
			if j >= squares[i-1] {
				dp[j] = min(dp[j], dp[j-squares[i-1]]+1)
			}
		}
	}

	if dp[n] > n {
		return -1
	}

	return dp[n]
}
