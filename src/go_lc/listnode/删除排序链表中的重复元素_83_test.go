package listnode

import "testing"

/**
给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。



示例 1：


输入：head = [1,1,2]
输出：[1,2]
示例 2：


输入：head = [1,1,2,3,3]
输出：[1,2,3]


提示：

链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
*/

func deleteDuplicates1(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	dummyHead := &ListNode{Next: head}
	pre, curr := dummyHead, head
	for curr != nil && curr.Next != nil {
		if curr.Val != curr.Next.Val {
			pre = curr
			curr = curr.Next
		} else {
			for curr.Next != nil && curr.Val == curr.Next.Val {
				curr = curr.Next
			}

			pre.Next = curr
		}
	}

	return dummyHead.Next
}

func TestDeleteDuplicates1(t *testing.T) {
	deleteDuplicates1(createLinkedList([]int{1, 1, 2, 2}))
}
