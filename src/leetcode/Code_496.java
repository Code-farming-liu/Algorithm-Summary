package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Code_496
 * @Description: 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * @Author: Admin
 **/

public class Code_496 {
    /**
     * @Author: Admin
     * @Description:
     *判别是否需要使用单调栈，如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈；
     *
     * 我们对nums2使用单调栈，使用map结构存储对应的关系, 最后再去同步nums1的结果数组
     *
     * 单调栈，我们使用一个栈记录元素的下标，
     *
     * 1. 栈为空直接添加进入栈
     * 2. 当前元素大于栈顶的元素，证明找到了升温日期，则将对应的栈顶弹出，并记录即可。
     * @param nums1
     * @param nums2
     * @return: int[]
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] res = new int[length1];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < length1; i++) {
            res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return res;
    }
}