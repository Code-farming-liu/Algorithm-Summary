package 二叉树

import (
	"fmt"
	"math"
	"testing"
)

/*
*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
*/
func minDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}

	fmt.Println(root.Val)
	l := minDepth(root.Left)
	r := minDepth(root.Right)
	if l == 0 {
		l = math.MaxInt
	}
	if r == 0 {
		r = math.MaxInt
	}

	if l == math.MaxInt && r == math.MaxInt {
		return 1
	}
	return min(l, r) + 1
}

func TestMinDepth(t *testing.T) {
	root := &TreeNode{Val: 1}
	root.Right = &TreeNode{Val: 9}
	root.Right.Right = &TreeNode{Val: 20}
	root.Right.Right.Right = &TreeNode{Val: 15}
	root.Right.Right.Right.Right = &TreeNode{Val: 7}
	mi := minDepth(root)
	println(mi)
}
