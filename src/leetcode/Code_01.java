package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code_01
 * @Description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @Author: Admin
 **/

public class Code_01 {
    /**
     * @param nums
     * @param target
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用map辅助遍历，使用数组元素作为key， 元素的下标作为value
     *
     * 我们首先求出当前值与目标的差值，
     *
     * 1. 如果这个差值在这个hash表中，我们直接返回对应的value，
     * 2. 如果不在这个hash表中，那么我们将当前值作为key保存起来
     *
     * @return: int[]
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 求和，反转思维求出差值
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{i, map.get(temp)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}