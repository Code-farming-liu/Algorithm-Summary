package leetcode;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *  
 * <p>
 * 提示: 
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 */
public class Code_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        if (k <= 1) {
            return 0;
        }
        int j = 0;
        int cur = 1;
        for (int i = 0; i < n; i++) {
            cur *= nums[i];
            while (cur >= k) {
                cur /= nums[j++];
            }
            res += i - j + 1;
        }
        return res;
    }
}
