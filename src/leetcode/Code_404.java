package leetcode;

/**
 * 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * <p>
 * 输入: root = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 */
public class Code_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        help(root, false);
        return sum;
    }

    public int help(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (flag) {
                sum += root.val;
            }
            return sum;
        }
        int left = help(root.left, true);
        int right = help(root.right, false);
        return sum;
    }
}
