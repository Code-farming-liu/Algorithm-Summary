/**
 * @ClassName: Test55
 * @Description: 删除链表的倒数第n个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * @Author: Admin
 **/

public class Test55 {
    //    public static ListNode1 removeNthFromEnds(ListNode1 head, int n) {
//        ListNode1 listNode11 = new ListNode1(0);
//        listNode11.next = head;
//        ListNode1 listNode1 = delPreNode(listNode11, n);
//        if(getLength(listNode11) == 1){
//            return null;
//        }
//        listNode1.next = listNode1.next.next;
//        return listNode11;
//    }
//    public static int getLength(ListNode1 head){
//        if(head.next == null){
//            return 0;
//        }
//        ListNode1 temp = head.next;
//        int length = 0;
//        while(temp != null){
//            length++;
//            temp = temp.next;
//        }
//        return length;
//    }
//    public static ListNode1 delPreNode(ListNode1 head,int n){
//        if(head.next == null){
//            return null;
//        }
//        int size = getLength(head);
//        if(n < 0 || n > size){
//            return null;
//        }
//        if(size == 1){
//            return head;
//        }
//        ListNode1 cur = head.next;
//        for (int i = 0; i < size - n - 1; i++) {
//            cur = cur.next;
//        }
//        return cur;
//    }
    //方法一
//    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
//        ListNode1 dummy = new ListNode1(0);
//        dummy.next = head;
//        int length = 0;
//        //链表的长度
//        ListNode1 first = head;
//        while (first != null) {
//            length++;
//            first = first.next;
//        }
//        //找到要删除元素的前一个节点
//        length -= n;
//        first = dummy;//要删除元素的前一个节点
//        while (length > 0) {
//            length--;
//            first = first.next;
//        }
//        first.next = first.next.next;
//        return dummy.next;
//    }

    //采用快慢指针的方法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //设置头指针
        ListNode pre = new ListNode(0);
        pre.next = head;
        //设置快慢指针
        ListNode fast = pre, slow = pre;
        //快指针先比慢指针走n步
        while (n != 0) {
            fast = fast.next;
            n--;
        }

        //快慢指针同时走，当快指针到达终点
        //慢指针正好就是我们需要删除的节点
        //同理 快指针快到终点
        // 慢指针就是我们要删除节点的前一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}