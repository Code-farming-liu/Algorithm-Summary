package offer;

import offer.ListNode;

/**
 * @ClassName: Test15
 * @Description: 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @Author: Admin
 **/

public class Code_15 {
    //使用递归
    /**
     * @Author: Admin
     * @Description: 思路描述：
     * 当然我们也可以使用递归遍历，将当前链表节点的下一个节点指向该节点：head.next.next = head
     * @param head
     * @return: offer.ListNode
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = ReverseList(head.next);
        //将该链表的下一个节点指向该节点
        head.next.next = head;
        //断开连接
        head.next = null;
        return res;
    }
    //使用一个新的链表辅助遍历
    /**
     * @Author: Admin
     * @Description: 思路描述：
     *
     * 我们可以使用一个新的链表pre辅助遍历，将原链表cur的每个节点都放在新的链表的最前面
     * cur.next = pre ,之后我们返回新的链表即可。
     * @param head
     * @return: offer.ListNode
     */
    public ListNode ReverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            //保存cur的下一个节点
            ListNode temp = cur.next;
            //将cur节点加入到pre的前面 断开连接
            cur.next = pre;
            //将cur 赋值给pre 使后面的节点可以在pre的前面
            pre = cur;
            //将cur 赋值给cur节点之后的链表
            cur = temp;
        }
        return pre;
    }
}