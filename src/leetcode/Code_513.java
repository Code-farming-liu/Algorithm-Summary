package leetcode;

/**
 * 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Code_513 {

    int max = Integer.MIN_VALUE;
    int result;
    public int findBottomLeftValue(TreeNode root) {
        traversal(root, 0);
        return result;
    }

    public void traversal(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            // 收集结果
            if (depth > max) {
                max =depth;
                result = root.val;
            }
            return;
        }
        if (root.left != null) {
            depth++;
            traversal(root.left, depth);
            depth--;
        }
        if (root.right != null) {
            depth++;
            traversal(root.right, depth);
            depth--;
        }
    }
}
