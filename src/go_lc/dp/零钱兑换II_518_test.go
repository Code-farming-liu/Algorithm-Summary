package dp

import "sort"

/*
*
给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

假设每一种面额的硬币有无限个。

题目数据保证结果符合 32 位带符号整数。

示例 1：

输入：amount = 5, coins = [1, 2, 5]
输出：4
解释：有四种方式可以凑成总金额：
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2：

输入：amount = 3, coins = [2]
输出：0
解释：只用面额 2 的硬币不能凑成总金额 3 。
示例 3：

输入：amount = 10, coins = [10]
输出：1

提示：

1 <= coins.length <= 300
1 <= coins[i] <= 5000
coins 中的所有值 互不相同
0 <= amount <= 5000
*/
func change2(amount int, coins []int) int {
	sort.Ints(coins)
	dp := make([][]int, len(coins)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, amount+1)
	}

	// 初始化
	dp[0][0] = 1
	for i := 1; i < len(dp); i++ { // 物品
		for j := 0; j <= amount; j++ { // 背包
			if j < coins[i-1] {
				dp[i][j] += dp[i-1][j]
			} else {
				dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]
			}
		}
	}

	return dp[len(coins)][amount]
}

func change(amount int, coins []int) int {
	sort.Ints(coins)
	dp := make([]int, amount+1)

	// 初始化
	dp[0] = 1
	for i := 1; i <= len(coins); i++ { // 物品
		for j := coins[i-1]; j <= amount; j++ { // 背包
			dp[j] += +dp[j-coins[i-1]]
		}
	}

	return dp[amount]
}
