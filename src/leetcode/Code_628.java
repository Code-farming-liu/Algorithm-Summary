package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Code_628
 * @Description: 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * @Author: Admin
 **/

public class Code_628 {
    /**
     * @Author: Admin
     * @Description: 思路描述
     * 1. 我们只需要找到最小的两个数，与最大一个数进行乘积，(考虑负数)
     * 2. 或者直接是最大的三个数进行乘积。
     * 3. 去两种情况中的最大值
     * @param nums
     * @return: int
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length - 1;
        return Math.max(nums[0] * nums[1] * nums[length], nums[length] * nums[length - 1] * nums[length - 2]);
    }

    // 相同思路
    public int maximumProduct1(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}