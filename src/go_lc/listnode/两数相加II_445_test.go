package listnode

/*
*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例1：

输入：l1 = [7,2,4,3], l2 = [5,6,4]
输出：[7,8,0,7]
示例2：

输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[8,0,7]
示例3：

输入：l1 = [0], l2 = [0]
输出：[0]

提示：

链表的长度范围为 [1, 100]
0 <= node.val <= 9
输入数据保证链表代表的数字无前导 0

进阶：如果输入链表不能翻转该如何解决？
*/
func addTwoNumbers2(l1 *ListNode, l2 *ListNode) *ListNode {
	var reverse func(head *ListNode) *ListNode
	reverse = func(head *ListNode) *ListNode {
		var pre *ListNode
		for head != nil {
			next := head.Next
			head.Next = pre
			pre = head
			head = next
		}
		return pre
	}

	l1 = reverse(l1)
	l2 = reverse(l2)
	dummyHead := &ListNode{}
	curr := dummyHead
	add := 0
	for l1 != nil || l2 != nil || add != 0 {
		sum := add
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		curr.Next = &ListNode{Val: sum % 10}
		curr = curr.Next
		add = sum / 10
	}
	return reverse(dummyHead.Next)
}
