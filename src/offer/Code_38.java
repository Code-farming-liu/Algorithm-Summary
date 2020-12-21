package offer;

/**
 * @ClassName: Test34
 * @Description: 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @Author: Admin
 **/

public class Code_38 {
    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 我们先来理解什么是二叉树的深度 其实就是从根节点到各个叶子节点的最大值。
     * 二叉树都是由各个子树所组成，因此我们可以递归遍历各个子树，
     * 最后返回 根节点到各个叶子节点之间的最大值
     * @return: int
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = TreeDepth(root.left);
        int rightLength = TreeDepth(root.right);
        return Math.max(leftLength, rightLength) + 1;
    }
}