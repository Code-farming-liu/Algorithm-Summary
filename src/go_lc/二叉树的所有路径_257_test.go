package leetcode

import (
	"fmt"
	"strings"
	"testing"
)

/*
*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。

示例 1：

输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
示例 2：

输入：root = [1]
输出：["1"]

提示：

树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100
*/
func binaryTreePaths(root *TreeNode) []string {
	res := []string{}
	if root == nil {
		return res
	}

	st := make([]string, 0)
	var dfs func(root *TreeNode, str []string)
	dfs = func(root *TreeNode, str []string) {
		if root == nil {
			return
		}

		str = append(str, fmt.Sprintf("%v", root.Val))
		if root.Left == nil && root.Right == nil {
			t := make([]string, len(str))
			copy(t, str)
			res = append(res, strings.Join(t, "->"))
		}

		dfs(root.Left, str)
		dfs(root.Right, str)
		str = str[:len(str)-1]
	}
	dfs(root, st)
	return res
}

func TestBinaryTreePaths(t *testing.T) {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Left.Right = &TreeNode{Val: 5}
	binaryTreePaths(root)
}
