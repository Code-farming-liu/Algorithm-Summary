package listnode

import "testing"

/*
* 你可以选择使用单链表或者双链表，设计并实现自己的链表。

单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。

如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。

实现 MyLinkedList 类：

MyLinkedList() 初始化 MyLinkedList 对象。
int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。

示例：

输入
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
输出
[null, null, null, null, 2, null, 3]

解释
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
myLinkedList.get(1);              // 返回 2
myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
myLinkedList.get(1);              // 返回 3

提示：

0 <= index, val <= 1000
请不要使用内置的 LinkedList 库。
调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
*/
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
