package leetcode

/**
给你一个二叉树的根节点 root ， 检查它是否轴对称。



示例 1：


输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：


输入：root = [1,2,2,null,3,null,3]
输出：false


提示：

树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100
*/

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	var dfs func(left *TreeNode, right *TreeNode) bool
	dfs = func(left *TreeNode, right *TreeNode) bool {
		if left == nil && right == nil {
			return true
		}

		if left == nil || right == nil || left.Val != right.Val {
			return false
		}

		return dfs(left.Left, right.Right) && dfs(left.Right, right.Left)
	}
	return dfs(root.Left, root.Right)
}
