package leetcode;

import java.util.List;

/**
 * @ClassName: Code_83
 * @Description: 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @Author: Admin
 **/

public class Code_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        new Code_83().deleteDuplicates(node1);
    }

    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println();
    }
}