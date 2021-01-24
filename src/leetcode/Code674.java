package leetcode;

/**
 * @ClassName: Code674
 * @Description: 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * @Author: Admin
 * @Date 2021/1/24 10:12
 **/

public class Code674 {
    /**
     * @param nums
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用双指针 fast， slow，结果变量为res
     *
     * 1. 当 nums[i] > nums[i - 1]时，fast++；
     * 2. 当 nums[i] <= nums[i - 1]
     * 3. res 即为 当前值与 fast - slow + 1的最大值
     * @return: int
     */
    public static int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int res = 0;
        // slow
        int start = 0;
        // i 相当于 fast
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}