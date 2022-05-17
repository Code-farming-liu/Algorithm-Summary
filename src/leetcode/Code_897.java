package leetcode;

import java.util.Stack;

/**
 * @ClassName: Code_897
 * @Description: 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * @Author: Admin
 * @Date 2021/4/25 18:54
 **/

public class Code_897 {
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            cur.right = root;
            root.left = null;
            cur = cur.right;
            root = root.right;
        }
        cur.right = null;
        return res.right;
    }

    TreeNode head = new TreeNode(-1);
    TreeNode pre = head;
    public TreeNode increasingBST1(TreeNode root) {
        inorder(root);
        return head.right;
    }
    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        pre.right = node;
        pre = node;
        pre.left = null;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        increasingBST(root);
    }
}