package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(root1, res);
        dfs(root2, temp);
        res.addAll(temp);
        Collections.sort(res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}
