package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Code_234
 * @Description: 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * @Author: Admin
 **/

public class Code_234 {
    /**
     * @param head
     * @Author: Admin
     * @Description: 思路描述：
     * 首先我们可以将对应节点值放在一个数组或者集合中，之后我们使用双指针遍历即可。
     * @return: boolean
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param head
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用快慢指针找到中点，将中点以后的部分反转，之后我们将前半部分和后半部分进行对比，我们便能实现双指针的比较。
     * @return: boolean
     */
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow;
        ListNode reverse = reverse(temp);
        slow = head;
        fast = reverse;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    // 反转链表
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}