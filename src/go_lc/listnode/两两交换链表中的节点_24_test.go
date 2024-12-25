package listnode

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
