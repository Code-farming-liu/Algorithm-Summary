package leetcode

import "math"

/*
二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。

示例 1：

输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：

输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

提示：

树中节点数目范围是 [1, 3 * 104]
-1000 <= Node.val <= 1000
*/
func maxPathSum(root *TreeNode) int {
	res := math.MinInt32
	if root == nil {
		return 0
	}
	var dfs func(root *TreeNode) int
	dfs = func(node *TreeNode) int {
		if node == nil {
			return 0
		}
		left := dfs(node.Left)
		right := dfs(node.Right)
		if left < 0 {
			left = 0
		}
		if right < 0 {
			right = 0
		}
		res = max(res, left+right+node.Val)
		return max(left, right) + node.Val
	}
	dfs(root)
	return res
}
