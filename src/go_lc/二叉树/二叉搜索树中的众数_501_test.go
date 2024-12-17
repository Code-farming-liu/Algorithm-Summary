package 二叉树

import (
	"fmt"
	"testing"
)

/**
给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

如果树中有不止一个众数，可以按 任意顺序 返回。

假定 BST 满足如下定义：

结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树


示例 1：


输入：root = [1,null,2,2]
输出：[2]
示例 2：

输入：root = [0]
输出：[0]


提示：

树中节点的数目在范围 [1, 104] 内
-105 <= Node.val <= 105


进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
*/

var (
	base  = 0
	count = 0
	m     = 0

	modeRes = []int{}
)

func findMode(root *TreeNode) []int {
	modeRes = make([]int, 0)
	base = 0
	count = 0
	m = 0
	findModeDFS(root)
	return modeRes
}

func findModeDFS(root *TreeNode) {
	if root == nil {
		return
	}
	findModeDFS(root.Left)
	findModeHelper(root.Val)
	findModeDFS(root.Right)
}

func findModeHelper(num int) {
	if num != base {
		base = num
		count = 1
	} else {
		count++
	}

	if count == m {
		modeRes = append(modeRes, num)
	}

	if count > m {
		modeRes = []int{}
		m = count
		modeRes = append(modeRes, num)
	}
}

func TestFindModeHelper(t *testing.T) {
	nums := []int{1, 2, 2, 3, 3, 3}
	base, m, count := 0, 0, 0
	for _, num := range nums {
		if num != base {
			base = num
			count = 1
		} else {
			count++
		}

		if count == m {
			modeRes = append(modeRes, num)
		}

		if count > m {
			modeRes = []int{}
			m = count
			modeRes = append(modeRes, num)
		}
	}

	fmt.Println(modeRes)
}
