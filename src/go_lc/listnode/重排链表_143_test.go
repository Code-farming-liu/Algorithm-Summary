package listnode

import "testing"

// 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// L0 → L1 → … → Ln - 1 → Ln
// 请将其重新排列后变为：
//
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
// 示例 1：
//
// 输入：head = [1,2,3,4]
// 输出：[1,4,2,3]
// 示例 2：
//
// 输入：head = [1,2,3,4,5]
// 输出：[1,5,2,4,3]
//
// 提示：
//
// 链表的长度范围为 [1, 5 * 104]
// 1 <= node.val <= 1000
func reorderList(head *ListNode) {
	if head == nil {
		return
	}

	dummyHead := &ListNode{Next: head}
	slow, fast := dummyHead, dummyHead
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}

	var reverse func(head *ListNode) *ListNode
	reverse = func(head *ListNode) *ListNode {
		if head == nil {
			return head
		}
		var pre *ListNode
		cur := head
		for cur != nil {
			next := cur.Next
			cur.Next = pre
			pre = cur
			cur = next
		}
		return pre
	}

	backNode := reverse(slow.Next)
	slow.Next = nil

	curr := head
	for curr != nil && backNode != nil {
		preNext := curr.Next
		postNext := backNode.Next
		backNode.Next = preNext
		curr.Next = backNode
		curr = preNext
		backNode = postNext
	}
}

func TestRecorderList(t *testing.T) {
	// 创建头节点
	head := &ListNode{Val: 1}

	// 创建第二个节点并链接
	head.Next = &ListNode{Val: 2}

	// 创建第三个节点并链接
	head.Next.Next = &ListNode{Val: 3}

	// 创建第四个节点并链接
	head.Next.Next.Next = &ListNode{Val: 4}

	// 创建第五个节点并链接
	head.Next.Next.Next.Next = &ListNode{Val: 5}
	//
	//// 创建第六个节点并链接
	//head.Next.Next.Next.Next.Next = &ListNode{Val: 6}

	reorderList(head)
}
