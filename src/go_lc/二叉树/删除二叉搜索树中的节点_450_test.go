package 二叉树

/*
*
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。

示例 1:

输入：root = [5,3,6,2,4,null,7], key = 3
输出：[5,4,6,2,null,null,7]
解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
另一个正确答案是 [5,2,6,null,4,null,7]。

示例 2:

输入: root = [5,3,6,2,4,null,7], key = 0
输出: [5,3,6,2,4,null,7]
解释: 二叉树不包含值为 0 的节点
示例 3:

输入: root = [], key = 0
输出: []

提示:

节点数的范围 [0, 104].
-105 <= Node.val <= 105
节点值唯一
root 是合法的二叉搜索树
-105 <= key <= 105

进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
*/

// root 为空，代表未搜索到值为 key 的节点，返回空。
//root.val>key，表示值为 key 的节点可能存在于 root 的左子树中，需要递归地在 root.left 调用 deleteNode，并返回 root。
//root.val<key，表示值为 key 的节点可能存在于 root 的右子树中，需要递归地在 root.right 调用 deleteNode，并返回 root。
//root.val=key，root 即为要删除的节点。此时要做的是删除 root，并将它的子树合并成一棵子树，保持有序性，并返回根节点。
//根据 root 的子树情况分成以下情况讨论：
//root 为叶子节点，没有子树。此时可以直接将它删除，即返回空。
//root 只有左子树，没有右子树。此时可以将它的左子树作为新的子树，返回它的左子节点。
//root 只有右子树，没有左子树。此时可以将它的右子树作为新的子树，返回它的右子节点。
//root 有左右子树，这时可以将 root 的后继节点（比 root 大的最小节点，即它的右子树中的最小节点，记为 successor）
//作为新的根节点替代 root，并将 successor 从 root 的右子树中删除，使得在保持有序性的情况下合并左右子树。
//简单证明，successor 位于 root 的右子树中，因此大于 root 的所有左子节点；successor 是 root 的右子树中的最小节点，
//因此小于 root 的右子树中的其他节点。以上两点保持了新子树的有序性。
//在代码实现上，我们可以先寻找 successor，再删除它。successor 是 root 的右子树中的最小节点，
//可以先找到 root 的右子节点，再不停地往左子节点寻找，直到找到一个不存在左子节点的节点，这个节点即为 successor。
//然后递归地在 root.right 调用 deleteNode 来删除 successor。
//因为 successor 没有左子节点，因此这一步递归调用不会再次步入这一种情况。然后将 successor 更新为新的 root 并返回。

func deleteNode1(root *TreeNode, key int) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Val > key {
		root.Left = deleteNode(root.Left, key)
	} else if root.Val < key {
		root.Right = deleteNode(root.Right, key)
	} else {
		if root.Left == nil && root.Right == nil {
			return nil
		}

		if root.Left != nil && root.Right == nil {
			return root.Left
		}

		if root.Right != nil && root.Left == nil {
			return root.Right
		}

		successor := root.Right
		for successor.Left != nil {
			successor = successor.Left
		}
		successor.Right = deleteNode(root.Right, successor.Val)
		successor.Left = root.Left
		return successor
	}
	return root
}

func deleteNode(root *TreeNode, key int) *TreeNode {
	var cur, curParent *TreeNode = root, nil
	for cur != nil && cur.Val != key {
		curParent = cur
		if cur.Val > key {
			cur = cur.Left
		} else {
			cur = cur.Right
		}
	}
	if cur == nil {
		return root
	}
	if cur.Left == nil && cur.Right == nil {
		cur = nil
	} else if cur.Right == nil {
		cur = cur.Left
	} else if cur.Left == nil {
		cur = cur.Right
	} else {
		successor, successorParent := cur.Right, cur
		for successor.Left != nil {
			successorParent = successor
			successor = successor.Left
		}
		if successorParent.Val == cur.Val {
			successorParent.Right = successor.Right
		} else {
			successorParent.Left = successor.Right
		}
		successor.Right = cur.Right
		successor.Left = cur.Left
		cur = successor
	}
	if curParent == nil {
		return cur
	}
	if curParent.Left != nil && curParent.Left.Val == key {
		curParent.Left = cur
	} else {
		curParent.Right = cur
	}
	return root
}
