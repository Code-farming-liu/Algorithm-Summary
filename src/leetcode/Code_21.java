package leetcode;

/**
 * @ClassName: Code_21
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author: Admin
 **/

public class Code_21 {
    /**
     * @param l1
     * @param l2
     * @Author: Admin
     * @Description: 思路描述
     * 我们使用一个新的链表进行辅助
     *
     * 1. l1.val < l2.val  , 将l1的连接到新的链表的后面，l1 = l1.next
     * 2. l1.val >= l2.val, 将l2的连接到新的链表的后面，l2 = l2.next
     *
     * 最后将剩余部分的链表连接到新的链表的后面，因为链表长度不一样，导致l1结束了l2有剩余
     * @return: leetcode.ListNode
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 将剩余的链表连接。
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
}