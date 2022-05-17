package leetcode;

public class Code_337 {
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robTree(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        // 偷最大值
        int val1 = root.val + left[0] + right[0];
        // 不偷最大值
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val2, val1};
    }
}
