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
	//var reverse func(st, ed *ListNode) *ListNode
	//reverse = func(st, ed *ListNode) *ListNode {
	//	curr, prev := st.Next, st
	//	prev.Next = ed
	//	for curr != nil && curr != ed {
	//		next := curr.Next
	//		curr.Next = prev
	//		prev = curr
	//		curr = next
	//	}
	//	return prev
	//}

	curr1, curr2 := head, head

	var prev *ListNode
	len := 0
	for curr1 != nil {
		len++
		if len == k {
			prev = curr1
		}
		curr1 = curr1.Next
	}
	index := len - k
	for index > 0 {
		curr2 = curr2.Next
		index--
	}

	if prev == nil || prev == curr2 {
		return head
	}

	prev.Val, curr2.Val = curr2.Val, prev.Val
	return head
}

func TestS(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	//head.Next.Next = &ListNode{Val: 3}
	//head.Next.Next.Next = &ListNode{Val: 4}
	//head.Next.Next.Next.Next = &ListNode{Val: 5}
	println(swapNodes(head, 2))
}
