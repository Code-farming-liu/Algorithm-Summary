package 动态规划

/**
有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。

每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。



示例 1：

输入：stones = [2,7,4,1,8,1]
输出：1
解释：
组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
示例 2：

输入：stones = [31,26,33,21,40]
输出：5


提示：

1 <= stones.length <= 30
1 <= stones[i] <= 100
*/

func lastStoneWeightIA(stones []int) int {
	if len(stones) == 0 {
		return 0
	}

	sum := 0
	for _, v := range stones {
		sum += v
	}
	target := sum / 2
	dp := make([][]int, len(stones))
	for i := range dp {
		dp[i] = make([]int, target+1) // 初始化背包
	}

	for j := 0; j <= target; j++ {
		if j < stones[0] {
			continue
		}
		dp[0][j] = stones[0]
	}

	for i := 1; i < len(stones); i++ { // 遍历物品
		for j := 0; j <= target; j++ { // 代表背包
			if j < stones[i] { // 不选择 stones[i]
				dp[i][j] = dp[i-1][j]
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i]) // 选择stones[i]
			}
		}
	}
	return sum - dp[len(stones)-1][target]*2
}

func lastStoneWeightII(stones []int) int {
	if len(stones) == 0 {
		return 0
	}

	sum := 0
	for _, v := range stones {
		sum += v
	}
	target := sum / 2
	dp := make([]int, target+1)

	for i := 0; i < len(stones); i++ { // 遍历物品
		for j := target; j >= stones[i]; j-- { // 代表背包
			dp[j] = max(dp[j], dp[j-stones[i]]+stones[i]) // 选择stones[i]
		}
	}
	return sum - dp[target]*2
}
