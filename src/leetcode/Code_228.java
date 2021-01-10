package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_228
 * @Description: 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 * @Author: Admin
 **/

public class Code_228 {
    /**
     * @param nums
     * @Author: Admin
     * @Description: 思路描述：
     * 我们只要找到连续上升的子序列，这个就是一个区间的范围，我们使用low指针记录区间的左边界，high记录区间的右边界
     *
     * 1. low < high  我们按照题意添加 nums[low] + "->" + nums[high]
     * 2. low == high 我们按照题意添加 nums[low] + ""
     * @return: java.util.List<java.lang.String>
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int length = nums.length;
        if (nums == null) {
            return res;
        }
        int i = 0;
        while (i < length) {
            // 区间左边界
            int low = i;
            i++;
            // 找到连续上升的子序列
            while (i < length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            // 区间右边界
            int high = i - 1;
            StringBuilder sb = new StringBuilder(nums[low] + "");
            // 如果区间有范围
            if (low < high) {
                sb.append("->");
                sb.append(nums[high] + "");
                res.add(sb.toString());
            }
            // 如果区间就是一个单独的值
            if (low == high) {
                res.add(sb.toString());
            }
        }
        return res;
    }
}