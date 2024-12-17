package 二叉树

/**
给定两棵二叉树 tree1 和 tree2，判断 tree2 是否以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。
注意，空树 不会是以 tree1 的某个节点为根的子树具有 相同的结构和节点值 。



示例 1：







输入：tree1 = [1,7,5], tree2 = [6,1]
输出：false
解释：tree2 与 tree1 的一个子树没有相同的结构和节点值。
示例 2：



输入：tree1 = [3,6,7,1,8], tree2 = [6,1]
输出：true
解释：tree2 与 tree1 的一个子树拥有相同的结构和节点值。即 6 - > 1。


提示：

0 <= 节点个数 <= 10000
*/

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil || B == nil {
		return false
	}

	if A.Val == B.Val && sameTree1(A, B) {
		return true
	}

	return isSubStructure(A.Left, B) ||
		isSubStructure(A.Right, B)

}
func sameTree1(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}

	if left == nil {
		return false
	}

	if right == nil {
		return true
	}

	if left.Val != right.Val {
		return false
	}

	return sameTree1(left.Left, right.Left) &&
		sameTree1(left.Right, right.Right)
}
