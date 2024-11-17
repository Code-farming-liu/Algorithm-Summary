package leetcode

/**
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。



示例 1:


输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:

输入: preorder = [-1], inorder = [-1]
输出: [-1]


提示:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
*/

func buildTree1(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}
	root := &TreeNode{}
	rootVal := preorder[0]
	root.Val = rootVal
	for i, v := range inorder {
		if v != rootVal {
			continue
		}
		root.Left = buildTree(preorder[1:i+1], inorder[0:i])
		root.Right = buildTree(preorder[i+1:], inorder[i+1:])
		break
	}
	return root
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	tm := map[int]int{}
	for i := 0; i < len(inorder); i++ {
		tm[inorder[i]] = i
	}

	var dfs func(preorder []int, inorder []int, pleft, pright, ileft, iright int) *TreeNode
	dfs = func(preorder []int, inorder []int, pleft, pright, ileft, iright int) *TreeNode {
		if pleft > pright || ileft > iright {
			return nil
		}
		root := &TreeNode{}
		rootVal := preorder[pleft]
		root.Val = rootVal
		rIndex := tm[rootVal]
		root.Left = dfs(preorder, inorder, pleft+1, rIndex-ileft+pleft, ileft, rIndex-1)
		root.Right = dfs(preorder, inorder, rIndex-ileft+pleft+1, pright, rIndex+1, iright)
		return root
	}
	return dfs(preorder, inorder, 0, len(preorder)-1, 0, len(inorder)-1)
}
