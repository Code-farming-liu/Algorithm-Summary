/**
 * @ClassName: Test95
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/11/23 18:15
 **/

public class Test95 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为null
        if (root == null) {
            return null;
        }
        // 如果他俩其中一个是根节点
        if (p == root || q == root) {
            return root;
        }
        // 假设 left 以及 right 都是已经算出结果的
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left为null,则必定在右边
        if (left == null) {
            return right;
        }
        // 如果right为null,则必定在左边
        if (right == null) {
            return left;
        }
        // 如果都不为null,那就是在两边,所以返回root即可
        if (left != null && right != null) {
            return root;
        }
        // 都为空,返回空
        return null;
    }
}