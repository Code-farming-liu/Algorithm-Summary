package listnode

import "testing"

/*
*
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：

输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：

输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000
*/
func reverseKGroup(head *ListNode, k int) *ListNode {
	var reverse func(st, ed *ListNode) *ListNode
	reverse = func(st, ed *ListNode) *ListNode {
		curr, prev := st.Next, st
		prev.Next = ed
		for curr != ed {
			next := curr.Next
			curr.Next = prev
			prev = curr
			curr = next
		}
		return prev
	}

	dummyHead := &ListNode{Next: head}
	curr := dummyHead
	for curr.Next != nil {
		i := 0
		prev := curr
		for ; i < k && curr.Next != nil; i++ {
			curr = curr.Next
		}
		if i%k == 0 {
			t := prev.Next
			prev.Next = reverse(prev.Next, curr.Next)
			curr = t
		}
	}
	return dummyHead.Next
}

func TestReversG(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 3}
	head.Next.Next.Next = &ListNode{Val: 4}
	head.Next.Next.Next.Next = &ListNode{Val: 5}
	println(reverseKGroup(head, 2))
}
