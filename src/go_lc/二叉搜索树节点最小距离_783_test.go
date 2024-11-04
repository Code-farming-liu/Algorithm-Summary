package leetcode

import (
	"math"
	"testing"
)

/*
*
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

差值是一个正数，其数值等于两值之差的绝对值。

示例 1：

输入：root = [4,2,6,1,3]
输出：1
示例 2：

输入：root = [1,0,48,null,null,12,49]
输出：1

提示：

树中节点的数目范围是 [2, 100]
0 <= Node.val <= 105
*/
func minDiffInBST(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ans := math.MaxInt64
	pre := -1
	minDiffInBSTDFS := func(node *TreeNode) {}
	minDiffInBSTDFS = func(node *TreeNode) {
		if node == nil {
			return
		}
		minDiffInBSTDFS(node.Left)
		t := node.Val - pre
		if pre != -1 && t < ans {
			ans = t
		}
		pre = node.Val
		minDiffInBSTDFS(node.Right)
	}
	minDiffInBSTDFS(root)
	return ans
}

func TestO(t *testing.T) {
	root := &TreeNode{Val: 1}
	node1 := &TreeNode{Val: 2}
	node2 := &TreeNode{Val: 3}
	root.Right = node1
	node1.Left = node2
	minDiffInBST(root)
}
