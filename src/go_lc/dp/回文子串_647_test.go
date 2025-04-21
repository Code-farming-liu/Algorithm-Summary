package dp

/**
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。

子字符串 是字符串中的由连续字符组成的一个序列。



示例 1：

输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

*/

func countSubstrings(s string) int {
	dp := make([][]bool, len(s))
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]bool, len(s))
	}

	res := 0
	for i := len(s) - 1; i >= 0; i-- {
		for j := i; j < len(s); j++ {
			if s[i] == s[j] {
				if j-i < 2 { // 代表首位相同且之有 a aa
					res++
					dp[i][j] = dp[i+1][j-1]
					continue
				}
				if dp[i+1][j-1] {
					res++
					dp[i][j] = dp[i+1][j-1] // 首尾相同 但是 aba
				}
			}
		}
	}
	return res
}
