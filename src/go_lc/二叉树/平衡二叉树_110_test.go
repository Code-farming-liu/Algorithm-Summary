package 二叉树

import (
	"math"
	"testing"
)

/*
*给定一个二叉树，判断它是否是
平衡二叉树

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：true
示例 2：

输入：root = [1,2,2,3,3,null,null,4,4]
输出：false
示例 3：

输入：root = []
输出：true
*/
func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	_, b := check(root)
	return b
}

func check(root *TreeNode) (int, bool) {
	if root == nil {
		return 0, true
	}
	left, lb := check(root.Left)
	if !lb {
		return 0, false
	}
	right, rb := check(root.Right)
	if !rb {
		return 0, false
	}
	if math.Abs(float64(left)-float64(right)) > 1 {
		return 0, false
	}
	return max(left, right) + 1, true
}

func TestDepth(t *testing.T) {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 9}
	root.Right = &TreeNode{Val: 20}
	root.Right.Left = &TreeNode{Val: 15}
	root.Right.Right = &TreeNode{Val: 7}
	mi := isBalanced(root)
	println(mi)
}
