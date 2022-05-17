package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Code_143
 * @Description: 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * @Author: Admin
 **/

public class Code_143 {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        ListNode stack_cur = new ListNode(0);

        while (cur.next != stack_cur.next) {
            stack_cur = stack.poll();
            stack_cur.next = cur.next;
            cur.next = stack_cur;

            cur = cur.next.next;
        }
        // 避免环形链表
        stack_cur.next = null;
    }

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
        reorderList(node1);
    }
}