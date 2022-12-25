package leetcode;

/**
 * @ClassName: Code_24
 * @Description: 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * @Author: Admin
 **/

public class Code_24 {

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs1(next.next);
        next.next = head;
        return next;
    }

    /**
     * @param head
     * @Author: Admin
     * @Description: 思路描述：
     * 我们正常交换位置即可
     *
     * 1. 首先使用start，end两个节点表示要交换的节点
     * 2. 接下来 用一个temp指针保存end的next temp = end.next
     * 3. 我们将start.next = end.next；
     * 4. end.next = start；
     * 5. temp = start
     *
     * 举例来说吧  链表 1 - 2 - 3 - 4
     *
     * start = 1 - 2 - 3 - 4
     *
     * end = 2 - 3 - 4
     *
     * temp = 3 - 4
     *
     * 执行 start.next = end.next；  start = 1 - 3 - 4
     *
     * 执行 end.next = start； end = 2 - 1 - 3 - 4
     *
     * 执行temp = start  temp = 1 - 3 - 4
     *
     * head = 2 - 1 - 3 - 4
     *
     * 循环此过程即可
     * @return: leetcode.ListNode
     */

    public static ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        swapPairs1(node2);
    }


    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs3(next.next);
        next.next = head;
        return next;
    }
}