package leetcode;

public class Code_783 {
    int res = Integer.MAX_VALUE;
    Integer cur = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (cur != null) {
            res = Math.min(res, Math.abs(cur - root.val));
        }
        cur = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
//        dfs(root);
    }
}
