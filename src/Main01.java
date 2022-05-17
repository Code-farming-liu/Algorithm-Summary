/**
 * @ClassName: Main01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/29 19:45
 **/

public class Main01 {
    public ListNode reverseList (ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}