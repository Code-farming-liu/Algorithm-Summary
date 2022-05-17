package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Code_40
 * @Description: 组合总和II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @Author: Admin
 **/

public class Code_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    public static void dfs(List<List<Integer>> res, List<Integer> list, int depth, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = depth; i < candidates.length; i++) {
            System.out.println("判断条件 ===> i = " + i + " depth = " + depth);
            if (i > depth && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            System.out.println("递归之前 => " + list + "，剩余 = " + (target - candidates[i]) + " i = " + i + " depth = " + depth);

            dfs(res, list, i + 1, candidates, target - candidates[i]);
            list.remove(list.size() - 1);
            System.out.println("递归之后 => " + list + "，剩余 = " + (target - candidates[i]) + " i = " + i + " depth = " + depth);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,2,1,2};
        combinationSum2(nums, 5);
    }
}

class A {
    public static int lastStrLen(String str) {
        String[] spilt = str.split(" ");
        return spilt[spilt.length - 1].length();
    }

    public static void main(String[] args) {
        int res = lastStrLen("hello nowcoder");
        System.out.println(res);
    }
}