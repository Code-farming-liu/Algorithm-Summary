package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_77
 * @Description: 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * @Author: Admin
 **/

public class Code_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, new ArrayList<>(), n, k, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int n, int k, int depth) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = depth; i < n; i++) {
            list.add(i + 1);
            dfs(res, list, n, k, i);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recur(n, k ,new ArrayList<>(), res, 0);
        return res;
    }

    public void recur(int n, int k, List<Integer> list, List<List<Integer>> res, int startIndex) {
        if (list.size() == k) {
            // 收集结果
            res.add(new ArrayList<>(list));
            return;
        }
        // 处理当前层逻辑
        for (int i = startIndex; i < n - (k - list.size()) + 1; i++) {
            list.add(i + 1);
            // 往下开始递归
            recur(n, k, list, res, i + 1);
            // 清除全局的一些变量 回溯
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        new Code_77().combine(4, 2);
    }
}