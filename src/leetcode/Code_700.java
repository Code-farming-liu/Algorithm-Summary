package leetcode;

public class Code_700 {
    public TreeNode searchBST1(TreeNode root, int val) {
        return root == null ? null : root.val == val ? root : root.val > val ?
                searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}
