package listnode

/*
*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

示例 1：

输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]

提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
*/
func swapPairs(head *ListNode) *ListNode {
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

	dummy := &ListNode{Next: head}
	curr := dummy
	for curr.Next != nil {
		i := 0
		prev := curr
		for ; i < 2 && curr.Next != nil; i++ {
			curr = curr.Next
		}
		if i%2 == 0 {
			t := prev.Next
			prev.Next = reverse(prev.Next, curr.Next)
			curr = t
		}
	}
	return dummy.Next
}
