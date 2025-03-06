package listnode

import "testing"

/**
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。



示例 1：


输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
示例 2：

输入：head = [2,1], x = 2
输出：[1,2]


提示：

链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200
*/

func partition(head *ListNode, x int) *ListNode {
	if head == nil {
		return head
	}

	pre := &ListNode{}
	res := pre
	tail := &ListNode{}
	t := tail
	cur := head
	for cur != nil {
		if cur.Val < x {
			pre.Next = cur
			pre = pre.Next
		} else {
			tail.Next = cur
			tail = tail.Next
		}
		cur = cur.Next
	}
	tail.Next = nil
	pre.Next = t.Next
	return res.Next
}

func TestPartition(t *testing.T) {
	partition(createLinkedList([]int{1, 4, 3, 2, 5, 2}), 3)
}
