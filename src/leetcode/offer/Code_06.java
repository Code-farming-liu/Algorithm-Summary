package leetcode.offer;

import leetcode.ListNode;

import java.util.Stack;

public class Code_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            nums[i++] = stack.pop();
        }
        return nums;
    }
}
