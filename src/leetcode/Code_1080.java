package leetcode;

/**
 * @ClassName: Code_1080
 * @Description: 根到叶路径上的不足节点
 * 给定一棵二叉树的根 root，请你考虑它所有 从根到叶的路径：从根到任何叶的路径。（所谓一个叶子节点，就是一个没有子节点的节点）
 *
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 *
 * 请你删除所有不足节点，并返回生成的二叉树的根。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 *
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 *
 *
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 *
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 *
 *
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 *
 * @Author: Admin
 **/

public class Code_1080 {
    /**
     * @Author: Admin
     * @Description:
     * 利用对应的dfs后续遍历每次判断对应的节点是否需要删除
     *
     * 1. 使用父亲节点删除孩子节点的方式删除节点
     *
     * 2. 删除节点的方式从下到上，因此使用后续遍历
     *
     * 3. 如果左右孩子节点都被删除，那么父亲节点也一定会被删除
     *
     *    如果左右孩子节点有一个被保留，那么父亲节点就会被保留
     * @param root
     * @param limit
     * @return: leetcode.TreeNode
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDelete = dfs(root, limit, 0);
        return rootDelete ? null : root;
    }

    public boolean dfs(TreeNode root, int limit, int cur) {
        // 证明是叶子结点
        if (root.left == null && root.right == null) {
            return cur + root.val < limit;
        }
        // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
        boolean leftTreeDelete = true;
        boolean rightTreeDelete = true;
        // 如果有左子树，就先递归处理左子树
        if (root.left != null) {
            leftTreeDelete = dfs(root.left, limit, cur + root.val);
        }
        // 如果有右子树，就先递归处理右子树
        if (root.right != null) {
            rightTreeDelete = dfs(root.right, limit, cur + root.val);
        }

        if (leftTreeDelete) {
            root.left = null;
        }
        if (rightTreeDelete) {
            root.right = null;
        }
        return leftTreeDelete && rightTreeDelete;
    }

    public TreeNode sufficientSubset1(TreeNode root, int limit) {
        return helper(root, limit, 0);
    }

    private TreeNode helper(TreeNode root, int limit, int cur) {
        if (root == null) {
            return null;
        }
        cur += root.val;
        if (root.left == null && root.right == null) {
            if (cur < limit) {
                return null;
            }
            return root;
        }
        root.left = helper(root.left, limit, cur);
        root.right = helper(root.right, limit, cur);
        // 证明左右孩子都是被删除的,所以当前节点也不需要保存
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}