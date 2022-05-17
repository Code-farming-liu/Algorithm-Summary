package leetcode;

/**
 * @ClassName: Code_61
 * @Description: 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *
 * @Author: Admin
 **/

public class Code_61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int num = k % length;
        if (num == 0) {
            return head;
        }
        ListNode fast = head;
        while (num > 0) {
            fast = fast.next;
            num--;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next;
        fast.next = head;
        slow.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        rotateRight(node1, 2);
    }
}