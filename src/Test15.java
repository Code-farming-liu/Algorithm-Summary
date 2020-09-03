/**
 * @ClassName: Test15
 * @Description: 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Author: Admin
 **/

public class Test15 {
    //使用递归
//    public ListNode ReverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode res = ReverseList(head.next);
//        //将该链表的下一个节点指向该节点
//        head.next.next = head;
//        //断开连接
//        head.next = null;
//        return res;
//    }
    //使用一个新的链表辅助遍历
//    public ListNode ReverseList(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur != null) {
//            //保存cur的下一个节点
//            ListNode temp = cur.next;
//            //将cur节点加入到pre的前面 断开连接
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//    }

    //    public static ListNode2 reverseList(ListNode2 heads) {
//        ListNode2 head = new ListNode2(0);
//        head.next = heads;
//        ListNode2 cur = head.next;
//        if(head.next == null || head.next.next == null){
//            return null;
//        }
//        return reverseList(head);
//    }

}