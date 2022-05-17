package leetcode;

/**
 * @ClassName: Code_104
 * @Description: 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @Author: Admin
 **/

public class Code_104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println("cur = " + root.val);
        int left = maxDepth(root.left);
        System.out.println("left = " + left);
        System.out.println("cur = " + root.val);
        int right = maxDepth(root.right);
        System.out.println("right = " + right);
        int temp = Math.max(left, right) + 1;
        System.out.println("cur = " + root.val);
        System.out.println("temp = " + temp);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        maxDepth(node1);
    }
}
