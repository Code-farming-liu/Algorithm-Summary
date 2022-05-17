package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_216
 * @Description: 组合问题III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @Author: Admin
 * @Date 2021/7/31 17:19
 **/

public class Code_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), k, n, 1, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int k, int n, int depth, int sum) {
        //终止条件(递归必须要有终止条件)
        if (list.size() == k) {
            //一些逻辑操作（可有可无，视情况而定）
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = depth; i <= 9 - (k - list.size()) + 1; i++) {
            //一些逻辑操作（可有可无，视情况而定）
            // 剪枝
            if (sum > n) {
                continue;
            }
            sum += i;
            //做出选择
            list.add(i);
            //递归
            backtrack(res, list, k, n, i + 1, sum);
            //一些逻辑操作（可有可无，视情况而定）
            //撤销选择
            sum -= i;
            list.remove(list.size() - 1);
        }
    }

//    public List<List<Integer>> combinationSum3(int k, int n) {
//
//    }

}