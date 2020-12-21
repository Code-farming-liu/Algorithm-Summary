package offer;

import offer.ListNode;

/**
 * @ClassName: Test14
 * @Description: 链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Author: Admin
 **/

public class Code_14 {
    /**
     * @Author: Admin
     * @Description:思路描述：
     *
     * 我们先确定链表的长度
     * 然后利用长度 - k 去找到要删除节点的前一个节点将其删除即可
     * @param head
     * @param k
     * @return: offer.ListNode
     */
    public ListNode FindKthToTail(ListNode head, int k) {
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