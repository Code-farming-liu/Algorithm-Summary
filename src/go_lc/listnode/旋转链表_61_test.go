package listnode

import "testing"

/**
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。



示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：


输入：head = [0,1,2], k = 4
输出：[2,0,1]


提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}

	dummyHead := &ListNode{Next: head}
	pre := dummyHead
	cur := head
	ll := 0
	for cur != nil {
		ll++
		cur = cur.Next
	}

	k = k % ll
	for i := 0; i < ll-k; i++ {
		pre = pre.Next
	}

	tail := pre.Next
	tailT := tail
	if tail == nil {
		return head
	}
	pre.Next = nil
	for tailT.Next != nil {
		tailT = tailT.Next
	}
	tailT.Next = head
	return tail
}

func TestRotateRight(t *testing.T) {
	head := createLinkedList([]int{1, 2})
	rotateRight(head, 2)
}
