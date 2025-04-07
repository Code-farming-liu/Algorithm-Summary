package dp

import (
	"strings"
	"testing"
)

/**
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。



示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。


提示：

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100
*/

func findMaxForm(strs []string, m int, n int) int {
	// 确定dp定义
	// dp[i][j][k] 表示在前 i 个字符串中，使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。
	// 确定递推公式
	// 如果 j<zeros 或 k<ones，则不能选第 i 个字符串，此时有 dp[i][j][k]=dp[i−1][j][k]；
	//
	//如果 j≥zeros 且 k≥ones，则如果不选第 i 个字符串，有 dp[i][j][k]=dp[i−1][j][k]，
	//如果选第 i 个字符串，有 dp[i][j][k]=dp[i−1][j−zeros][k−ones]+1，dp[i][j][k] 的值应取上面两项中的最大值。

	dp := make([][][]int, len(strs)+1)
	for i, _ := range dp {
		dp[i] = make([][]int, m+1)
		for j := range dp[i] {
			dp[i][j] = make([]int, n+1)
		}
	}

	for i, str := range strs {
		zero := strings.Count(str, "0")
		one := len(str) - zero
		for j := 0; j <= m; j++ {
			for k := 0; k <= n; k++ {
				dp[i+1][j][k] = dp[i][j][k]
				if j >= zero && k >= one {
					dp[i+1][j][k] = max(dp[i+1][j][k], dp[i][j-zero][k-one]+1)
				}
			}
		}
	}
	return dp[len(strs)][m][n]
}

// 二维DP解法（空间优化）
func findMaxForm1(strs []string, m int, n int) int {
	// 1. 确定dp定义
	// dp[j][k] 表示使用最多 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量。

	// 3. 初始化DP
	dp := make([][]int, m+1)
	for j := range dp {
		dp[j] = make([]int, n+1)
	}

	// 4. 确定遍历顺序
	for _, str := range strs {
		zero := strings.Count(str, "0")
		one := len(str) - zero

		// 逆序遍历，避免重复计算
		for j := m; j >= zero; j-- {
			for k := n; k >= one; k-- {
				// 2. 确定递推公式
				// dp[j][k] = max(dp[j][k], dp[j-zero][k-one]+1)
				dp[j][k] = max(dp[j][k], dp[j-zero][k-one]+1)
			}
		}
	}

	// 5. 返回结果
	return dp[m][n]
}

func TestFindMaxForm(t *testing.T) {
	strs := []string{"10", "0001", "111001", "1", "0"}
	findMaxForm(strs, 5, 3)

}
