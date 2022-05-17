package leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * <p>
 * 请你返回 nums 中唯一元素的 和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code_1748 {
    // Hash 计数
    public int sumOfUnique1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                res += key;
            }
        }
        return res;
    }

    public int sumOfUnique2(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num - 1]++;
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                res += (i + 1);
            }
        }
        return res;
    }

    // 双指针法
    public int sumOfUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length;) {
            int j = i;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j - i <= 1) {
                res += nums[i];
            }
            i = j;
        }
        return res;
    }

}
