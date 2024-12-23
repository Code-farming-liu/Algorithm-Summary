package 二叉树

import (
	"fmt"
	"testing"
)

/**
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。



示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]


提示：

树中节点总数在范围 [0, 5000] 内
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/

func pathSum(root *TreeNode, targetSum int) [][]int {
	res := [][]int{}
	if root == nil && targetSum >= 0 {
		return res
	}

	var dfs func(*TreeNode, []int, int)
	dfs = func(node *TreeNode, path []int, target int) {
		if node == nil {
			return
		}

		path = append(path, node.Val)
		target -= node.Val
		if node.Left == nil && node.Right == nil && target == 0 {
			res = append(res, path)
			return
		}

		dfs(node.Left, path, target)
		dfs(node.Right, path, target)
	}

	dfs(root, []int{}, targetSum)
	return res
}

func TestPathSum(t *testing.T) {
	root := &TreeNode{Val: 5}
	root.Left = &TreeNode{Val: 4}
	root.Left.Left = &TreeNode{Val: 11}
	root.Left.Left.Left = &TreeNode{Val: 7}
	root.Left.Left.Right = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 8}
	root.Right.Left = &TreeNode{Val: 13}
	root.Right.Right = &TreeNode{Val: 4}
	root.Right.Right.Left = &TreeNode{Val: 5}
	root.Right.Right.Right = &TreeNode{Val: 1}
	res := pathSum(root, 22)
	fmt.Println(res)
}
