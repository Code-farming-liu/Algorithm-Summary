package listnode

import "testing"

/*
*
给你一个单链表的头节点 head ，请你判断该链表是否为
回文链表
。如果是，返回 true ；否则，返回 false 。

示例 1：

输入：head = [1,2,2,1]
输出：true
示例 2：

输入：head = [1,2]
输出：false

提示：

链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9

进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/
func isPalindrome1(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}
	c := head
	ll := []int{}
	for c != nil {
		ll = append(ll, c.Val)
		c = c.Next
	}

	left, right := 0, len(ll)-1
	for left < right {
		if ll[left] != ll[right] {
			return false
		}
		left++
		right--
	}

	return true
}

func isPalindrome(head *ListNode) bool {
	f, s := head, head
	for f != nil && f.Next != nil {
		f = f.Next.Next
		s = s.Next
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

	node := reverse(s)

	for node != nil {
		if node.Val != head.Val {
			return false
		}
		node = node.Next
		head = head.Next
	}
	return true
}

func TestIs(t *testing.T) {
	head := &ListNode{Val: 1}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 2}
	head.Next.Next.Next = &ListNode{Val: 1}
	//head.Next.Next.Next.Next = &ListNode{Val: 5}
	isPalindrome(head)
}
