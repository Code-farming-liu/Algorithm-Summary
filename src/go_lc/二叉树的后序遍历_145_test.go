package leetcode

import (
	"fmt"
	"testing"
)

/**
给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。



示例 1：

输入：root = [1,null,2,3]

输出：[3,2,1]

解释：



示例 2：

输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]

输出：[4,6,7,5,2,9,8,3,1]

解释：



示例 3：

输入：root = []

输出：[]

示例 4：

输入：root = [1]

输出：[1]
*/

func postorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}

	stack := make([]*TreeNode, 0)
	destStack := make([]*TreeNode, 0)
	stack = append(stack, root)
	for len(stack) > 0 {
		root = stack[len(stack)-1]
		destStack = append(destStack, root)
		stack = stack[:len(stack)-1]
		// 寻找到左节点
		if root.Left != nil {
			stack = append(stack, root.Left)
		}
		// 寻找右节点
		if root.Right != nil {
			stack = append(stack, root.Right)
		}
	}

	for len(destStack) > 0 {
		res = append(res, destStack[len(destStack)-1].Val)
		destStack = destStack[:len(destStack)-1]
	}
	return res
}

func TestAA(t *testing.T) {
	// 创建一个二叉树
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Left.Left = &TreeNode{Val: 4}
	root.Left.Right = &TreeNode{Val: 5}
	root.Left.Right.Left = &TreeNode{Val: 6}
	root.Left.Right.Right = &TreeNode{Val: 7}
	root.Right.Right = &TreeNode{Val: 8}
	root.Right.Right.Left = &TreeNode{Val: 9}
	// 进行后序遍历
	fmt.Println("Postorder Traversal:")
	result := postorderTraversal(root)
	for _, value := range result {
		fmt.Println(value)
	}
}
