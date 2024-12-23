package listnode

import "testing"

/**
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


示例 1：


输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
示例 2：


输入：head = [1,2]
输出：[2,1]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000


进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
*/

func reverseList1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	last := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return last
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	var res *ListNode
	for head != nil {
		next := head.Next
		head.Next = res
		res = head
		head = next
	}

	return res
}

func TestReverseList(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 3}
	head.Next.Next.Next = &ListNode{Val: 4}
	result := reverseList(head)
	println(result)
}
