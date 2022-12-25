package leetcode;

/**
 * @ClassName: Code_25
 * @Description: K个一组反转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @Author: Admin
 **/

public class Code_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 空想的pre节点（接在头节点之前
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        // 用于记录头节点返回
        ListNode hair = pre;

        // 初始化tail，代表每个小段链表的末尾
        ListNode tail = pre;
        ListNode start, next;

        // 遍历链表
        while (tail.next != null) {
            // 移动tail到小段链表末尾
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            // 设置next
            next = tail.next;
            // 设置start为起始
            start = pre.next;
            // 断开链表
            tail.next = null;
            // 反转链表（head，tail)
            pre.next = reverse(start);
            // 接上链表末尾,此时start为反转后链表末尾
            start.next = next;
            // 移动指针寻找下一段链表
            pre = start;// 此时start已经是当前逆序链表的末尾
            tail = pre; // 移动末尾为pre下一次继续根据k移动tail
        }

        return hair.next;
    }

    /**
     * 反转链表
     *
     * @param head 头节点
     * @return
     */
    private static ListNode reverse(ListNode head) {
        // pre是指向前一个节点的指针，初始头节点前面的null
        ListNode pre = null;
        // curr是当前节点
        ListNode curr = head;
        while (curr != null) {
            // 记录下一个节点的指针
            ListNode next = curr.next;
            // 将指向下一个节点的指针反转指向前一个节点
            curr.next = pre;
            // 更新前一个节点（后移
            pre = curr;
            // 后移当前节点
            curr = next;
        }
        // 最后pre会移动到最后，但此时由于链表反转pre正好是反转后的头
        return pre;
    }

    // 链表的模板
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        reverseKGroup(node1, 2);
    }

}