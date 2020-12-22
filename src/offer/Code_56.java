package offer;

/**
 * @ClassName: Test48
 * @Description: 删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @Author: Admin
 **/

public class Code_56 {
    /**
     * @param pHead
     * @Author: Admin
     * @Description: 思路描述：
     *
     * 我们可以使用辅助指针遍历 ，一个指针（pre）始终指向当前指针（cur）的前一个节点（这样才可以删除）
     * 当有重复节点，我们将cur向前移动，将pre指针不不动，直到不是重复节点，
     * 或者当当前指针的下一个节点为null，也就证明遍历到链表的末尾了。
     * 也就是 cur.next != null && cur.val == cur.next.val
     * 这样我们只需要将 前一个指针的下一个节点指向当前指针的下一个节点，
     * 即可删除重复元素。即pre.next = cur.next
     * 否则，证明不是重复节点，因此我们将 pre，cur 指针都向后移动
     * 即pre = pre.next; cur = cur.next;
     * 注意：
     * pre 指针永远都在cur的前面，他们的起始位置是不相同的。
     * @return: offer.ListNode
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //设置头指针
        ListNode res = new ListNode(0);
        res.next = pHead;
        ListNode pre = res;
        ListNode cur = res.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //删除节点
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return res.next;
    }
}