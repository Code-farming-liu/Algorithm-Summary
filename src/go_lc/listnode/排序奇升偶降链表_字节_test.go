package listnode

import "testing"

/**
链表，奇数位置按序增长，偶数位置按序递减，如何能实现链表从小到大？（2020.10 字节跳动-后端）[2]
奇偶生序倒序链表的重新排序组合，例如：18365472（2020.08 字节跳动-后端）[3]
1->4->3->2->5 给定一个链表奇数部分递增，偶数部分递减，要求在O(n)时间复杂度内将链表变成递增，5分钟左右（2020.07 字节跳动-测试开发）[4]
奇数位升序偶数位降序的链表要求时间O(n)空间O(1)的排序？(2020.07 字节跳动-后端)[5]
可见，无论是后端还是测试开发，都曾被考察过这道题，而且这道题并非力扣上的题目，大家一定要注意！！

题目描述

给定一个奇数位升序，偶数位降序的链表，将其重新排序。

输入: 1->8->3->6->5->4->7->2->NULL
输出: 1->2->3->4->5->6->7->8->NULL
*/

func SortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var resverse func(head *ListNode) *ListNode
	resverse = func(head *ListNode) *ListNode {
		if head == nil || head.Next == nil {
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
	odd := &ListNode{Val: 0}
	even := &ListNode{Val: 0}
	oddTmp := odd
	evenTmp := even
	curr := head
	for i := 1; curr != nil; i++ {
		if i%2 == 0 {
			evenTmp.Next = curr
			evenTmp = evenTmp.Next
		} else {
			oddTmp.Next = curr
			oddTmp = oddTmp.Next
		}
		curr = curr.Next
	}
	oddTmp.Next = nil
	evenTmp.Next = nil

	l1 := odd.Next
	l2 := resverse(even.Next)
	dummyHead := &ListNode{Val: 0}
	curr = dummyHead
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			curr.Next = l1
			l1 = l1.Next
		} else {
			curr.Next = l2
			l2 = l2.Next
		}
		curr = curr.Next
	}
	if l1 != nil {
		curr.Next = l1
	} else {
		curr.Next = l2
	}
	return dummyHead.Next
}

func TestZiJie(t *testing.T) {
	node := createLinkedList([]int{1, 8, 3, 6, 5, 4, 7, 2})
	SortList(node)
}
