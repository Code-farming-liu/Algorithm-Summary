package leetcode;

/**
 * @ClassName: Code_110
 * @Description: 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 * @Author: Admin
 **/

public class Code_110 {
    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 我们判断一个树是否是平衡二叉树，我们只需要判断
     *
     * 1. 左树是否平衡
     * 2. 右树是否平衡
     * 3. 左右两树的高度相差是否小于等于 1
     * @return: boolean
     */
    public boolean isBalanced(TreeNode root) {
        return is(root) != -1;
    }

    public int is(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = is(root.left);
        if (left == -1) {
            return -1;
        }
        int right = is(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}