package offer;

/**
 * @ClassName: Test32
 * @Description: 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * @Author: Admin
 **/

public class Code_36 {
    /**
     * @param pHead1
     * @param pHead2
     * @Author: Admin
     * @Description: 思路描述：
     * 如果两个链表相交，那么相交之后的长度是相同的
     * 我们需要做的事情就是让两个链表从同距离末尾同等距离的位置开始遍历，这个位置只能是较短链表的头节点位置
     * 为此，我们必须消除两个链表的长度差
     *
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     *
     * 可以理解成两个人速度一致， 走过的路程一致。
     * 那么肯定会同一个时间点到达终点。如果到达终点的最后一段路两人都走的话，
     * 那么这段路上俩人肯定是肩并肩手牵手的。
     * @return: offer.ListNode
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            //消除距离差
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}