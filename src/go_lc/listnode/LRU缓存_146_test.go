package listnode

/*
*
请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4

提示：

1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put
*/
type doubleLinkedList struct {
	Key  int
	Val  int
	Pre  *doubleLinkedList
	Next *doubleLinkedList
}
type LRUCache struct {
}

var (
	m    = make(map[int]*doubleLinkedList)
	size = 0
	cap  = 0
	head = &doubleLinkedList{}
	tail = &doubleLinkedList{}
)

func Constructors(capacity int) LRUCache {
	cap = capacity
	head = &doubleLinkedList{}
	tail = &doubleLinkedList{}
	head.Next = tail
	tail.Pre = head
	m = make(map[int]*doubleLinkedList)
	return LRUCache{}
}

func (this *LRUCache) Get(key int) int {
	node := m[key]
	if node == nil {
		return -1
	}
	// 移动改节点到首部
	moveHead(node)
	return node.Val
}

func (this *LRUCache) Put(key int, value int) {
	node := m[key]
	if node != nil {
		node.Val = value
		moveHead(node)
		return
	}

	hn := &doubleLinkedList{
		Key: key,
		Val: value,
	}
	m[key] = hn
	addHead(hn)
	if len(m) > cap {
		t := removeTail()
		delete(m, t.Key)
	}
}

func moveHead(node *doubleLinkedList) {
	removeNode(node)
	addHead(node)
}

func removeNode(node *doubleLinkedList) {
	node.Pre.Next = node.Next
	node.Next.Pre = node.Pre
}

func addHead(node *doubleLinkedList) {
	node.Pre = head
	node.Next = head.Next
	head.Next.Pre = node
	head.Next = node
}

func removeTail() *doubleLinkedList {
	pre := tail.Pre
	removeNode(pre)
	return pre
}
