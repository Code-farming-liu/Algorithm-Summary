package leetcode;

/**
 * @ClassName: Code_124
 * @Description: 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例 2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出：42
 *
 * @Author: Admin
 **/

public class Code_124 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int left = Math.max(0, dfs(root.left));
        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int right = Math.max(0, dfs(root.right));
        //left->root->right 作为路径与已经计算过历史最大值做比较
        res = Math.max(res, root.val + left + right);
        // 返回经过root的单边最大分支给当前root的父节点计算使用
        return root.val + Math.max(left, right);
    }
}