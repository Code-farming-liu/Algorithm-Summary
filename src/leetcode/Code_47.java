package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Code_47
 * @Description: 全排列II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @Author: Admin
 **/

public class Code_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[length];
        dfs(res, new ArrayList<>(), visited, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(res, list, visited, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code_47().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}