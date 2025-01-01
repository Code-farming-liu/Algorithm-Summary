package listnode

import (
	"sort"
	"testing"
)

/*
*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

示例 1：

输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]

提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105

进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
*/
func sortList1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	list := []int{}
	curr := head
	for curr != nil {
		list = append(list, curr.Val)
		curr = curr.Next
	}

	sort.Ints(list)
	dummyHead := &ListNode{}
	t := dummyHead
	for _, v := range list {
		t.Next = &ListNode{Val: v}
		t = t.Next
	}
	return dummyHead.Next
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	var merge func(list1, list2 *ListNode) *ListNode
	merge = func(list1, list2 *ListNode) *ListNode {
		dummyHead := &ListNode{}
		curr := dummyHead
		for list1 != nil && list2 != nil {
			if list1.Val < list2.Val {
				curr.Next = list1
				list1 = list1.Next
			} else {
				curr.Next = list2
				list2 = list2.Next
			}
			curr = curr.Next
		}
		if list1 != nil {
			curr.Next = list1
		}
		if list2 != nil {
			curr.Next = list2
		}
		return dummyHead.Next
	}

	var sort func(head, tail *ListNode) *ListNode
	sort = func(head, tail *ListNode) *ListNode {
		if head == nil {
			return head
		}
		if head.Next == tail {
			head.Next = nil
			return head
		}

		slow, fast := head, head
		for fast != tail && fast.Next != tail {
			slow = slow.Next
			fast = fast.Next.Next
		}
		lt1 := sort(head, slow)
		lt2 := sort(slow, tail)
		return merge(lt1, lt2)
	}

	return sort(head, nil)
}

func TestSortList(t *testing.T) {
	head := &ListNode{Val: 4}
	head.Next = &ListNode{Val: 2}
	head.Next.Next = &ListNode{Val: 1}
	head.Next.Next.Next = &ListNode{Val: 3}
	ret := sortList(head)
	println(ret)
}
