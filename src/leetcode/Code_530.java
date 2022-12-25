package leetcode;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 */
public class Code_530 {
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        help(root);
        return min;
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre != -1) {
            int t = Math.abs(pre - root.val);
            if (t < min) {
                min = t;
            }
        }
        pre = root.val;
        help(root.right);
    }
}
