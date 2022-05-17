package codeTop_backed;

import leetcode.ListNode;

/**
 * @ClassName: Code01
 * @Description: 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * @Author: Admin
 * @Date 2021/5/29 17:13
 **/

public class Code_206 {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
        }
        return res;
    }
}