package leetcode;

/**
 * @ClassName: Code_jzoffer_22
 * @Description: 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * @Author: Admin
 **/

public class Code_jzoffer_22 {
    /**
     * @param head
     * @param k
     * @Author: Admin
     * @Description: 思路描述
     * 我们使用快慢指针辅助，我们将对应的快指针先走K步，之后慢指针在走，
     * 当快指针到达终点的时候，慢指针刚好可以到达我们需要的链表的前一个位置，
     * 直接返回慢指针即可。
     * @return: leetcode.ListNode
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * @param head
     * @param k
     * @Author: Admin
     * @Description: 思路描述：
     * 我们先确定链表的长度
     * 然后利用长度 - k 去找到要删除节点的前一个节点将其删除即可
     * @return: leetcode.ListNode
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (k > length) {
            return null;
        }
        length -= k;
        ListNode cur = head;
        while (length > 0) {
            length--;
            cur = cur.next;
        }
        return cur;
    }
}