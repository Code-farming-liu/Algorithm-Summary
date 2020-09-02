/**
 * @ClassName: Test14
 * @Description: 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @Author: Admin
 **/

public class Test14 {
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