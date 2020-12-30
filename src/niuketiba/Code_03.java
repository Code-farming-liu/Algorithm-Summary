package niuketiba;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Code_03
 * @Description: 链表中环的入口节点
 * 题目描述
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 * @Author: Admin
 **/

public class Code_03 {
    /**
     * @param head
     * @Author: Admin
     * @Description: 思路描述
     * 快慢指针首先指向最开始，然后利用快指针走两步，慢指针走一步，
     * 如果快指针为null那么证明没有环，
     * <p>
     * 否则快慢指针相遇，快指针指向开始，之后快慢指针一起移动，
     * 两个指针相遇的位置就是环的入口节点
     * @return: niuketiba.ListNode
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * @param pHead
     * @Author: Admin
     * @Description:
     * 还可以使用 set 集合判断，如果没有这个节点 直接加入进去，
     * 如果有那么直接返回即可。
     * @return: niuketiba.ListNode
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
            }
            pHead = pHead.next;
        }
        return pHead;
    }
}