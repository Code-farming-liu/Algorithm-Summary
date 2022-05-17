package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_46
 * @Description: 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @Author: Admin
 **/

public class Code_46 {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<>(), nums, visited);
        return res;
    }


    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                dfs(res, list, nums, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    public void dfs (List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}