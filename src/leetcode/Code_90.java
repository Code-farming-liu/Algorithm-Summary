package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recur(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public void recur(List<List<Integer>> res, List<Integer> list, int start, int[] nums) {
        res.add(new ArrayList<>(list));
        // 处理当前层逻辑
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            recur(res, list, i + 1, nums);
            list.remove(list.size() - 1);
        }
        // 往下开始递归

        // 清除全局的一些变量 回溯
    }
}
