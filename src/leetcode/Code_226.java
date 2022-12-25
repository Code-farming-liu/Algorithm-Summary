package leetcode;

import java.util.LinkedList;

public class Code_226 {
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                TreeNode t = node.left;
                node.left = node.right;
                node.right = t;
            }
        }
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        node.left = right;
        node.right = left;
        return node;
    }
}
