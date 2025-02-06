package listnode

import "testing"

/*
*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[

	1->4->5,
	1->3->4,
	2->6

]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]

提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
*/
func mergeKLists1(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}

	if len(lists) == 1 {
		return lists[0]
	}

	var mergeList func(l *ListNode, r *ListNode) *ListNode
	mergeList = func(l *ListNode, r *ListNode) *ListNode {
		p1, p2 := l, r
		dummyHead := &ListNode{}
		curr := dummyHead
		for p1 != nil && p2 != nil {
			if p1.Val <= p2.Val {
				curr.Next = p1
				p1 = p1.Next
			} else {
				curr.Next = p2
				p2 = p2.Next
			}
			curr = curr.Next
		}
		if p1 != nil {
			curr.Next = p1
		}
		if p2 != nil {
			curr.Next = p2
		}
		return dummyHead.Next
	}
	resp := mergeList(lists[0], lists[1])
	for i := 2; i < len(lists); i++ {
		resp = mergeList(resp, lists[i])
	}
	return resp
}

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	if len(lists) == 1 {
		return lists[0]
	}
	var mergeList func(l *ListNode, r *ListNode) *ListNode
	mergeList = func(l *ListNode, r *ListNode) *ListNode {
		p1, p2 := l, r
		dummyHead := &ListNode{}
		curr := dummyHead
		for p1 != nil && p2 != nil {
			if p1.Val <= p2.Val {
				curr.Next = p1
				p1 = p1.Next
			} else {
				curr.Next = p2
				p2 = p2.Next
			}
			curr = curr.Next
		}
		if p1 != nil {
			curr.Next = p1
		}
		if p2 != nil {
			curr.Next = p2
		}
		return dummyHead.Next
	}

	var merge func(lists []*ListNode, l, r int) *ListNode
	merge = func(lists []*ListNode, l, r int) *ListNode {
		if l == r {
			return lists[l]
		}

		if l > r {
			return nil
		}

		mid := (l + r) / 2
		left := merge(lists, l, mid)
		right := merge(lists, mid+1, r)
		return mergeList(left, right)
	}

	return merge(lists, 0, len(lists)-1)
}

func TestMergeKLists(t *testing.T) {
	param := []*ListNode{
		{Val: 1, Next: &ListNode{Val: 4, Next: &ListNode{Val: 5, Next: nil}}},
		{Val: 1, Next: &ListNode{Val: 3, Next: &ListNode{Val: 4, Next: nil}}},
		{Val: 2, Next: &ListNode{Val: 6, Next: nil}},
	}
	mergeKLists(param)
}
