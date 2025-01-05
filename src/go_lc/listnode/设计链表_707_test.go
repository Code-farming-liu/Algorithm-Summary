package listnode

import "testing"

type MyLinkedList struct {
	Val  int
	Next *MyLinkedList
}

var dummyHead *MyLinkedList

func Constructor() MyLinkedList {
	dummyHead = &MyLinkedList{Next: nil}
	return MyLinkedList{}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 {
		return -1
	}
	curr := dummyHead.Next
	for index > 0 && curr != nil {
		curr = curr.Next
		index--
	}

	if curr == nil {
		return -1
	}
	return curr.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	curr := dummyHead
	t := dummyHead.Next
	curr.Next = &MyLinkedList{Val: val, Next: t}
}

func (this *MyLinkedList) AddAtTail(val int) {
	curr := dummyHead
	for curr.Next != nil {
		curr = curr.Next
	}
	curr.Next = &MyLinkedList{Val: val, Next: nil}
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index < 0 {
		return
	}
	curr := dummyHead
	for index > 0 && curr != nil {
		curr = curr.Next
		index--
	}
	if curr == nil {
		return
	}

	if curr.Next == nil {
		curr.Next = &MyLinkedList{Val: val, Next: nil}
		return
	}
	t := curr.Next
	curr.Next = &MyLinkedList{Val: val, Next: t}
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 {
		return
	}

	curr := dummyHead
	for index > 0 && curr.Next != nil {
		curr = curr.Next
		index--
	}

	if index > 0 || curr.Next == nil {
		return
	}
	curr.Next = curr.Next.Next
}

func TestDesignLinkedList(t *testing.T) {
	cmd := []string{"MyLinkedList", "deleteAtIndex"}
	args := [][]int{
		{}, {0}, {2}, {1}, {3, 0}, {2}, {6}, {4}, {4}, {4}, {5, 0}, {6},
	}

	var myLinkedList MyLinkedList
	for idx, v := range cmd {
		switch v {
		case "MyLinkedList":
			s := Constructor()
			myLinkedList = s
		case "addAtHead":
			myLinkedList.AddAtHead(args[idx][0])
		case "addAtTail":
			myLinkedList.AddAtTail(args[idx][0])
		case "addAtIndex":
			myLinkedList.AddAtIndex(args[idx][0], args[idx][1])
		case "get":
			myLinkedList.Get(args[idx][0])
		case "deleteAtIndex":
			myLinkedList.DeleteAtIndex(args[idx][0])
		}
	}
}
