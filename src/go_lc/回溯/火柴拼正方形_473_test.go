package 回溯

import "sort"

/**
你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。

如果你能使这个正方形，则返回 true ，否则返回 false 。



示例 1:



输入: matchsticks = [1,1,2,2,2]
输出: true
解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: matchsticks = [3,3,3,3,4]
输出: false
解释: 不能用所有火柴拼成一个正方形。


提示:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108
*/

func makesquare(matchsticks []int) bool {
	if len(matchsticks) < 4 {
		return false
	}

	sum := 0
	for _, v := range matchsticks {
		sum += v
	}
	if sum%4 != 0 {
		return false
	}

	target := sum / 4
	sort.Sort(sort.Reverse(sort.IntSlice(matchsticks)))

	edges := make([]int, 4) // 用于记录每条边的当前长度

	var dfs func(int) bool
	dfs = func(index int) bool {
		if index == len(matchsticks) {
			// 所有火柴都已分配，检查四条边是否相等
			for i := 1; i < 4; i++ {
				if edges[i] != edges[0] {
					return false
				}
			}
			return true
		}

		for i := 0; i < 4; i++ {
			if edges[i]+matchsticks[index] > target {
				continue
			}
			edges[i] += matchsticks[index]
			if dfs(index + 1) {
				return true
			}
			edges[i] -= matchsticks[index]

			// 剪枝：如果当前火柴无法放入第一条边，则直接退出
			if edges[i] == 0 {
				break
			}
		}
		return false
	}

	return dfs(0)
}
