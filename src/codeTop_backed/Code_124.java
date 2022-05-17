package codeTop_backed;

import leetcode.TreeNode;

/**
 * @ClassName: Code_124
 * @Description: 二叉树的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * @Author: Admin
 **/

public class Code_124 {
    static int res = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        int cur = 0;
        dfs(root, cur);
        return res;
    }

    public static void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur += Math.max(0, root.val);
        res = Math.max(cur, res);
        dfs(root.left, cur);
        dfs(root.right, cur);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        maxPathSum(root);
    }
}