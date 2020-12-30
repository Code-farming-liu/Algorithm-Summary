package leetcode;

/**
 * @ClassName: Code_92
 * @Description: 反转链表II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @Author: Admin
 **/

public class Code_92 {
    /**
     * @param head
     * @param m
     * @param n
     * @Author: Admin
     * @Description: 我们只需要将该链表分为三个部分，
     *
     * 1. m 以前
     * 2. m - n
     * 3. n 以后
     *
     * 将m - n的部分进行反转，最后再拼接在一个新的链表中。
     * @return: leetcode.ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 使用头结点
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        if (head == null || head.next == null) {
            return head;
        }
        // 代表前一部分的最后一个节点
        ListNode before = null;
        // 代表第二部分的 最后一个节点
        ListNode after = null;
        for (int i = 1; i <= m - 1; i++) {
            cur = cur.next;
        }
        before = cur;
        cur = cur.next;

        // 断开连接
        before.next = null;
        // 反转链表 m - n
        ListNode pre = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            if (cur == null) {
                break;
            }
            if (i == n) {
                after = cur.next;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 将第一部分与第二部分连接在一起
        before.next = pre;
        while (pre.next != null) {
            pre = pre.next;
        }
        // 将第二部分与 第三部分连接在一起
        pre.next = after;
        return res.next;
    }
}