package listnode

import "testing"

/*
* 给你链表的头节点 head 和一个整数 k 。

交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。

示例 1：

输入：head = [1,2,3,4,5], k = 2
输出：[1,4,3,2,5]
示例 2：

输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
输出：[7,9,6,6,8,7,3,0,9,5]
示例 3：

输入：head = [1], k = 1
输出：[1]
示例 4：

输入：head = [1,2], k = 1
输出：[2,1]
示例 5：

输入：head = [1,2,3], k = 2
输出：[1,2,3]

提示：

链表中节点的数目是 n
1 <= k <= n <= 105
0 <= Node.val <= 100
*/

func swapNodes(head *ListNode, k int) *ListNode {
	dummyHead := &ListNode{Next: head}
	pre1, pre2 := dummyHead, dummyHead
	left, right := head, head
	for i := 1; i < k; i++ {
		pre1 = left
		left = left.Next
	}

	cur := left
	temp := left.Next
	for cur.Next != nil {
		pre2 = right
		right = right.Next
		cur = cur.Next
	}

	if left == right {
		return dummyHead.Next
	}

	if right == pre1 {
		right.Next = temp
		left.Next = right
		pre2.Next = left
	} else {
		left.Next = right.Next
		if pre2 == left {
			right.Next = left
		} else {
			// 特殊情况，第k个节点在倒数第k个节点的左侧
			pre2.Next = left
			right.Next = pre2
		}
		pre1.Next = right
	}

	return dummyHead.Next
}

func TestS(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 3}
	head.Next.Next.Next = &ListNode{Val: 4}
	head.Next.Next.Next.Next = &ListNode{Val: 5}
	println(swapNodes(head, 1))
}
