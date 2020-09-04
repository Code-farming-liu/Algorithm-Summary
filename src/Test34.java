/**
 * @ClassName: Test34
 * @Description: 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @Author: Admin
 * @Date 2020/9/4 20:39
 **/

public class Test34 {
    public int TreeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLength = TreeDepth(root.left);
        int rightLength = TreeDepth(root.right);
        return Math.max(leftLength,rightLength) + 1;
    }
}