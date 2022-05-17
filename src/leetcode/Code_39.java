package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Code_39
 * @Description: 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * @Author: Admin
 * @Date 2021/4/20 14:56
 **/

public class Code_39 {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return res;
        }
        dfs(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int target, int[] candidates, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res, list, target - candidates[i], candidates, i + 1);
            list.remove(list.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recur(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    public void recur(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int startIndex) {
        if (0 == target) {
            // 收集结果
            res.add(new ArrayList<>(list));
            return;
        }
        // 处理当前层逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            // 往下开始递归
            recur(candidates, target - candidates[i], list, res, i);
            // 清除全局的一些变量 回溯
            list.remove(list.size() - 1);
        }
    }
}