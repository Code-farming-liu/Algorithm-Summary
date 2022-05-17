package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Code_491
 * @Description: 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *  
 *
 * 提示：
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: Admin
 * @Date 2021/8/1 12:22
 **/

public class Code_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start) {
        //终止条件(递归必须要有终止条件)
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        // set 只负责本层
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            //一些逻辑操作（可有可无，视情况而定）
            if (!list.isEmpty() && nums[i] < list.get(list.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            //做出选择
            list.add(nums[i]);
            //递归
            backtrack(res, list, nums, i + 1);
            //一些逻辑操作（可有可无，视情况而定）
            //撤销选择
            list.remove(list.size() - 1);
        }
    }
}