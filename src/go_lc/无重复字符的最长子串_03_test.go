package leetcode

import (
	"testing"
)

/*
*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长
子串

	的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。

	请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
*/
func lengthOfLongestSubstring(s string) int {
	n := len(s)
	if n == 0 {
		return 0
	}

	sc := []rune(s)
	rSet := map[rune]bool{}
	right := -1
	res := 0
	for left := 0; left < n; left++ {
		if left != 0 {
			delete(rSet, sc[left-1])
		}

		for right+1 < n && !rSet[sc[right+1]] {
			rSet[sc[right+1]] = true
			right++
		}

		res = max(res, right-left+1)
	}
	return res
}

func TestLengthOfLongestSubstring(t *testing.T) {
	lengthOfLongestSubstring("abcabcbb")
}
