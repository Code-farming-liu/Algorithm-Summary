package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_77
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/14 10:51
 **/

public class Code_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), res, 1, k, n);
        return res;
    }

    public static void dfs(List<Integer> list, List<List<Integer>> res, int start, int k, int n) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(list, res, i + 1, k, n);
            list.remove(list.size() - 1);
        }
    }
}