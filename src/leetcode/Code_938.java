package leetcode;

public class Code_938 {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        dfs(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            res += root.val;
        }
        dfs(root.right, low, high);
    }
}
