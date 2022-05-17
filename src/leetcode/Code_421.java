package leetcode;

/**
 * @ClassName: Code_421
 * @Description: 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [2,4]
 * 输出：6
 * 示例 4：
 *
 * 输入：nums = [8,10,2]
 * 输出：10
 *
 * @Author: Admin
 **/

public class Code_421 {
    public int findMaximumXOR(int[] nums) {
        int length = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}