package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Code_503
 * @Description: 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * @Author: Admin
 **/

public class Code_503 {
    public static int[] nextGreaterElements(int[] nums) {
        int length  = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length * 2; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElements(new int[]{1, 2, 1}));
    }
}