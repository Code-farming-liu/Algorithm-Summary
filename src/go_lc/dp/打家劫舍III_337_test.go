package dp

/*
*
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。

示例 1:

输入: root = [3,2,3,null,3,null,1]
输出: 7
解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
示例 2:

输入: root = [3,4,5,1,3,null,1]
输出: 9
解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9

提示：

树的节点数在 [1, 104] 范围内
0 <= Node.val <= 104
*/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func robTree(root *TreeNode) int {
	if root == nil {
		return 0
	}

	var dfs func(root *TreeNode) []int
	dfs = func(root *TreeNode) []int {
		if root == nil {
			return make([]int, 2)
		}
		leftDp := dfs(root.Left)
		rightDp := dfs(root.Right)

		// 偷根节点,不能偷左右节点
		val1 := root.Val + leftDp[0] + rightDp[0]

		// 不偷根节点, 左右节点可以偷
		val2 := max(leftDp[0], leftDp[1]) + max(rightDp[0], rightDp[1])

		return []int{val2, val1}
	}

	dp := dfs(root)
	return max(dp[0], dp[1])
}
