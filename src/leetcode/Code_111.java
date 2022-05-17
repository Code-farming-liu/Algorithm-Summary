package leetcode;

/**
 * @ClassName: Code_111
 * @Description: 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @Author: Admin
 **/

public class Code_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            int left = minDepth(root.left);
            res = Math.min(left, res);
        }
        if (root.right != null) {
            int right = minDepth(root.right);
            res = Math.min(right, res);
        }
        return res + 1;
    }
}