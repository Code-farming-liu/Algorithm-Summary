package listnode

import "testing"

/**
给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


示例 1：


输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：

输入：head = [5], left = 1, right = 1
输出：[5]
*/

func reverseBetween1(head *ListNode, left int, right int) *ListNode {
	h := &ListNode{Next: head}

	pre := h
	for i := 0; i < left-1; i++ {
		pre = pre.Next
	}

	rn := pre
	for i := 0; i < right-left+1; i++ {
		rn = rn.Next
	}

	leftNode := pre.Next
	succ := rn.Next

	pre.Next = nil
	rn.Next = nil

	var revers func(head *ListNode) *ListNode
	revers = func(head *ListNode) *ListNode {
		if head == nil {
			return head
		}
		var pre *ListNode
		for head != nil {
			next := head.Next
			head.Next = pre
			pre = head
			head = next
		}
		return pre
	}

	revers(leftNode)

	pre.Next = rn
	leftNode.Next = succ
	return h.Next
}

// 前插法
func reverseBetween(head *ListNode, left int, right int) *ListNode {
	h := &ListNode{Next: head}
	pre := h
	for i := 0; i < left-1; i++ {
		pre = pre.Next
	}

	curr := pre.Next
	// 先将 curr 的下一个节点记录为 next；
	//执行操作 ①：把 curr 的下一个节点指向 next 的下一个节点；
	//执行操作 ②：把 next 的下一个节点指向 pre 的下一个节点；
	//执行操作 ③：把 pre 的下一个节点指向 next。
	//
	for i := 0; i < right-left; i++ {
		// 先将 curr 的下一个节点记录为 next；
		next := curr.Next
		// 把 curr 的下一个节点指向 next 的下一个节点；
		curr.Next = next.Next
		// 把 next 的下一个节点指向 pre 的下一个节点；
		next.Next = pre.Next
		// 把 pre 的下一个节点指向 next。
		pre.Next = next
	}
	return h.Next
}

func TestReverseB(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 3}
	head.Next.Next.Next = &ListNode{Val: 4}
	head.Next.Next.Next.Next = &ListNode{Val: 5}
	result := reverseBetween(head, 2, 4)
	println(result)
}
