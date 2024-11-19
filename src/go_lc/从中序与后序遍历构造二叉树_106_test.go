package leetcode

/**
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。



示例 1:


输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
示例 2:

输入：inorder = [-1], postorder = [-1]
输出：[-1]


提示:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder 和 postorder 都由 不同 的值组成
postorder 中每一个值都在 inorder 中
inorder 保证是树的中序遍历
postorder 保证是树的后序遍历
*/

func buildTree2(inorder []int, postorder []int) *TreeNode {
	rm := make(map[int]int)
	for i, v := range inorder {
		rm[v] = i
	}

	var dfs func(inorder []int, postorder []int, il, ir, pl, pr int) *TreeNode
	dfs = func(inorder []int, postorder []int, il, ir, pl, pr int) *TreeNode {
		if il > ir || pl > pr {
			return nil
		}
		root := &TreeNode{}
		root.Val = postorder[pr]
		rIndex := rm[root.Val]

		root.Left = dfs(inorder, postorder, il, rIndex-1, pl, rIndex-il+pl-1)
		root.Right = dfs(inorder, postorder, rIndex+1, ir, rIndex-il+pl, pr-1)
		return root
	}
	return dfs(inorder, postorder, 0, len(inorder)-1, 0, len(postorder)-1)
}
