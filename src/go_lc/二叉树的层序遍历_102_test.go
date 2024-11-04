package leetcode

import "testing"

/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]


提示：

树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000

*/

func levelOrder(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	queue := []*TreeNode{root}
	for len(queue) != 0 {
		tmp := []int{}
		length := len(queue)
		for i := 0; i < length; i++ {
			node := queue[i]
			tmp = append(tmp, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}

			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		queue = queue[length:]
		res = append(res, tmp)
	}
	return res
}

func TestLevel(t *testing.T) {
	root := &TreeNode{Val: 1}
	node1 := &TreeNode{Val: 2}
	node2 := &TreeNode{Val: 3}
	root.Left = node1
	root.Right = node2
	levelOrder(root)
}
