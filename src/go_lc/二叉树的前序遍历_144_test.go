package leetcode

/*
*给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：

输入：root = [1,null,2,3]

输出：[1,2,3]

解释：

示例 2：

输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]

输出：[1,2,4,5,6,7,3,8,9]

解释：

示例 3：

输入：root = []

输出：[]

示例 4：

输入：root = [1]

输出：[1]

提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100

进阶：递归算法很简单，你可以通过迭代算法完成吗？
*/
func preorderTraversal1(root *TreeNode) []int {
	res := make([]int, 0)
	preOrderDfs(root, &res)
	return res
}

func preOrderDfs(root *TreeNode, path *[]int) {
	if root == nil {
		return
	}

	*path = append(*path, root.Val)
	preOrderDfs(root.Left, path)
	preOrderDfs(root.Right, path)
}

func preorderTraversal(root *TreeNode) []int {
	res := make([]int, 0)
	if root == nil {
		return res
	}

	stack := make([]*TreeNode, 0)
	for root != nil || len(stack) > 0 {
		for root != nil {
			stack = append(stack, root)
			res = append(res, root.Val)
			root = root.Left
		}

		// 取出上一个节点
		root = stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		root = root.Right
	}
	return res
}
