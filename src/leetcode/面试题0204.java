package leetcode;

/**
 * @ClassName: 面试题0204
 * @Description: 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * @Author: Admin
 * @Date 2021/9/24 21:44
 **/

public class 面试题0204 {
    public ListNode partition(ListNode head, int x) {
//        ListNode small = new ListNode(0);
//        ListNode large = new ListNode(0);
        ListNode sh = null, st = null, lh = null, lt = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                if (sh == null) {
                    sh = cur;
                    st = cur;
                } else {
                    st.next = cur;
                    st = cur;
                }
            } else {
                if (lh == null) {
                    lh = cur;
                    lt = cur;
                } else {
                    lt.next = cur;
                    lt = cur;
                }
            }
            cur = next;
        }
        if (st != null) {
            st.next = lh;
        }
        return sh != null ? sh : (lh != null ? lh : null);
    }
}