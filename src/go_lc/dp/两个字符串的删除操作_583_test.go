package dp

/**
给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。

每步 可以删除任意一个字符串中的一个字符。



示例 1：

输入: word1 = "sea", word2 = "eat"
输出: 2
解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
示例  2:

输入：word1 = "leetcode", word2 = "etco"
输出：4


提示：

1 <= word1.length, word2.length <= 500
word1 和 word2 只包含小写英文字母
*/

func minDistance(word1 string, word2 string) int {
	dp := make([][]int, len(word1)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(word2)+1)
		for j := 0; j <= len(word2); j++ {
			dp[i][j] = len(word1) + 1
		}
	}

	for i := 0; i < len(dp); i++ {
		dp[i][0] = i
	}

	for j := 0; j <= len(word2); j++ {
		dp[0][j] = j
	}

	// 可以删除任意一个字符串的字母  注意！！！！！！！
	for i := 1; i <= len(word1); i++ {
		for j := 1; j <= len(word2); j++ {
			if word1[i-1] != word2[j-1] { // 删除 s[i], 删除 t[i], 删除 s[i], t[i]
				dp[i][j] = min(dp[i-1][j]+1, min(dp[i][j-1]+1, dp[i-1][j-1]+2))
			} else {
				dp[i][j] = dp[i-1][j-1]
			}
		}
	}

	return dp[len(word1)][len(word2)]
}
