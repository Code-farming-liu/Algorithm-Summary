package leetcode;

/**
 * @ClassName: Code_86
 * @Description: 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 * @Author: Admin
 **/

public class Code_86 {
    /**
     * @param head
     * @param x
     * @Author: Admin
     * @Description: 思路描述：
     * 我们只需要新建两个链表，
     *
     * 1. 一个链表用来保存比x小的值
     * 2. 另一个链表用来保存大于等于x的值
     * 3. 最后将两个链表连接在一起。
     * 注意将最后的节点的next值设置为null，否则有可能形成环形链表
     * @return: leetcode.ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode preTemp = pre;
        ListNode tail = new ListNode(0);
        ListNode tailTemp = tail;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                preTemp.next = cur;
                preTemp = preTemp.next;
            } else {
                tailTemp.next = cur;
                tailTemp = tailTemp.next;
            }
            cur = cur.next;
        }
        // 防止形成环形链表。
        tailTemp.next = null;
        preTemp.next = tail.next;
        return pre.next;
    }
}