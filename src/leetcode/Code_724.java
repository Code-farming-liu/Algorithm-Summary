package leetcode;

/**
 * @ClassName: Code_724
 * @Description: 寻找数组的中心索引
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 * <p>
 * 注意：中心索引可能出现在数组的两端。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 索引 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。
 * 示例 4：
 * <p>
 * 输入：nums = [0, 0, 0, 0, 1]
 * 输出：4
 * 解释：
 * 索引 4 左侧数之和为 0 ；右侧不存在元素，视作和为 0 ，二者相等。
 * @Author: Admin
 **/

public class Code_724 {
    public int pivotIndex(int[] nums) {
        //特殊情况判断，空数组无法找到中心索引，长度为1的数组中心索引为0
        if (nums.length < 1) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }
        int sum = 0, left = 0, right;
        //数组求和
        for (int num : nums) {
            sum += num;
        }
        //对索引在1~length-1的数进行判断
        for (int i = 0; i < nums.length; i++) {
            //对数组第一个数特殊讨论：避免指针越界
            //算出索引左侧元素和
            left += i >= 1 ? nums[i - 1] : 0;
            //索引右侧元素和
            right = sum - left - nums[i];
            //如果两侧元素和相等，则该索引即为数组的中心索引
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}