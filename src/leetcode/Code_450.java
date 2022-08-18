package leetcode;

public class Code_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (root.val == key) {
            if (null == root.left) {
                return root.right;
            }
            if (null == root.right) {
                return root.left;
            }
            TreeNode t = root.left;
            while (null != t.right) {
                t = t.right;
            }
            t.right = root.right;
            return root.left;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
