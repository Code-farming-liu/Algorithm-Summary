package leetcode;

/**
 * @ClassName: Code_543
 * @Description: 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 * @Author: Admin
 **/

public class Code_543 {

    int res = 0;

    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以注意到题目中要求求解的是两点之间的路径长度，那么我们就以题目中的树为例，求解 4 到 3的直径，那我们我们可以分为两步，
     * 先求出根节点到4的深度，
     * 再求出跟节点到3的深度，对他们求和 - 1即为结果，
     * 这就转换为了求每个节点的深度。
     * @return: int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        // 因为返回的是边数 因此 减一
        return res - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左右子树的深度， 更新结果值
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }
}