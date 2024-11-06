package leetcode

/*
*
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

示例 1：

输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
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
func levelOrderBottom(root *TreeNode) [][]int {
	res := [][]int{}
	reverse := [][]int{}
	if root == nil {
		return res
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		tmp := []int{}
		length := len(queue)
		q := []*TreeNode{}
		for i := 0; i < length; i++ {
			node := queue[i]
			tmp = append(tmp, node.Val)
			if node.Left != nil {
				q = append(q, node.Left)
			}

			if node.Right != nil {
				q = append(q, node.Right)
			}
		}
		queue = q
		reverse = append(reverse, tmp)
	}

	for i := len(reverse) - 1; i >= 0; i-- {
		res = append(res, reverse[i])
	}

	return res
}
