package leetcode

import "testing"

/*
*给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。

示例 1：

输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]
*/
func flatten1(root *TreeNode) {
	if root == nil {
		return
	}

	tl := []int{}
	var dfs func(*TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		tl = append(tl, node.Val)
		dfs(node.Left)
		dfs(node.Right)
	}
	dfs(root)

	t := root
	for i := 1; i < len(tl); i++ {
		t.Right = &TreeNode{Val: tl[i]}
		t = t.Right
	}
	root.Left = nil
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	stack := []*TreeNode{root}
	var prev *TreeNode
	for len(stack) > 0 {
		curr := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		if prev != nil {
			prev.Left, prev.Right = nil, curr
		}
		left, right := curr.Left, curr.Right

		if right != nil {
			stack = append(stack, right)
		}
		if left != nil {
			stack = append(stack, left)
		}
		prev = curr
	}
}

func flatten3(root *TreeNode) {
	if root == nil {
		return
	}
	var pre *TreeNode
	var dfs func(*TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Right)
		dfs(node.Left)
		node.Left, node.Right = nil, pre
		pre = node
	}
	dfs(root)
}

func TestF(t *testing.T) {
	node := TreeNode{Val: 1}
	node.Left = &TreeNode{Val: 2}
	node.Left.Left = &TreeNode{Val: 3}
	node.Left.Right = &TreeNode{Val: 4}
	node.Right = &TreeNode{Val: 5}
	node.Right.Right = &TreeNode{Val: 6}
	flatten(&node)
}
