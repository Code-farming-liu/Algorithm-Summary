package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test81
 * @Description: LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
 * 则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
 * 从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * @Author: Admin
 **/

public class Code_146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * @Author: Admin
     * @Description: 我们可以使用对应的 hash表 和 双向链表进行辅助
     * LRU 缓存机制可以通过哈希表辅以双向链表实现，
     * 我们用一个哈希表和一个双向链表维护所有在缓存中的键值对。
     *
     * 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，
     * 而靠近尾部的键值对是最久未使用的。
     *
     * 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
     *
     * 这样以来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，
     * 随后将其移动到双向链表的头部，即可在 O(1)的时间内完成 get 或者 put 操作。具体的方法如下：
     *
     * 对于 get 操作，首先判断 key 是否存在：
     *
     * 如果 key 不存在，则返回 -1；
     *
     * 如果 key 存在，则 key 对应的节点是最近被使用的节点。
     * 通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
     *
     * 对于 put 操作，首先判断 key 是否存在：
     *
     * 如果 key 不存在，使用 key 和 value 创建一个新的节点，
     * 在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
     * 然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，
     * 并删除哈希表中对应的项；
     *
     * 如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，
     * 并将该节点移到双向链表的头部。
     * @param null
     * @return: null
     */
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public Code_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        movetoHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            movetoHead(node);
        }
    }

    public void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void movetoHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
}