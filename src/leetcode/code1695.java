package leetcode;

import java.util.*;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * <p>
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * <p>
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class code1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int right = -1;
        int res = 0;
        for (int left = 0; left < n; left++) {
            if (left != 0) {
                set.remove(nums[left - 1]);
            }

            while (right + 1 < n && !set.contains(nums[right + 1])) {
                set.add(nums[right + 1]);
                right++;
            }

            int sum = 0;
            int startIndex = left;
            while (startIndex <= right) {
                sum += nums[startIndex++];
            }

            res = Math.max(res, sum);
        }
        return res;
    }
}
