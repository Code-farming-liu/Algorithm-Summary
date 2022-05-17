package codeTop_backed;

import leetcode.TreeNode;

/**
 * @ClassName: Code_110
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/6/13 18:21
 **/

public class Code_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}