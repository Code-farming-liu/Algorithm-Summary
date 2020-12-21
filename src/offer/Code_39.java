package offer;

/**
 * @ClassName: Test35
 * @Description: 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * @Author: Admin
 **/

public class Code_39 {
    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 在做这道题之前，我们首先先来了解了解什么是平衡二叉树，它有什么特点
     * 它的特点就是左右子树的高度差不能大于1，至于树的深度我们已经求解过了，
     * 因此我们只需要求出左右子树的深度之后，将其做差查看结果是否小于1
     * 如果 小于1 证明为二叉平衡树，否则不是。
     * @return: boolean
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return help(root) != -1;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        if (left == -1) {
            return -1;
        }
        int right = help(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}