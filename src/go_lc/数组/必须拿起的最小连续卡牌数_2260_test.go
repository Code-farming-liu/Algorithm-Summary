package 数组

import (
	"math"
	"testing"
)

/*
*给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。

返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。

示例 1：

输入：cards = [3,4,2,3,4,7]
输出：4
解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
示例 2：

输入：cards = [1,0,5,3]
输出：-1
解释：无法找出含一对匹配卡牌的一组连续卡牌。

提示：

1 <= cards.length <= 105
0 <= cards[i] <= 106
*/

type data struct {
	exist bool
	index int
}

func minimumCardPickup1(cards []int) int {
	nm := map[int]data{}
	n := len(cards)
	res := n
	right := -1
	flag := true
	for left := 0; left < n; left++ {
		if left != 0 {
			delete(nm, cards[left-1])
		}

		for right+1 < n && !nm[cards[right+1]].exist {
			nm[cards[right+1]] = data{
				exist: true,
				index: right + 1,
			}
			right++
		}

		if right+1 >= n && flag {
			return -1
		}

		if right+1 >= n {
			return res
		}
		if flag {
			flag = false
		}
		res = min(res, right-nm[cards[right+1]].index+2)
	}
	return res
}

func minimumCardPickup(cards []int) int {
	nm := map[int]int{}
	n := len(cards)
	res := math.MaxInt
	for left := 0; left < n; left++ {
		val := cards[left]
		idx, ok := nm[val]
		if ok {
			res = min(res, left-idx+1)
		}
		nm[val] = left
	}

	if res == math.MaxInt {
		return -1
	}
	return res
}

func TestA(t *testing.T) {
	println(minimumCardPickup([]int{0, 0}))
}
