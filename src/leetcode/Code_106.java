package leetcode;


import java.util.Arrays;

/**
 * @ClassName: Test47
 * @Description: 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @Author: Admin
 **/

public class Code_106 {
    /**
     * @param inorder
     * @param postorder
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用
     * 后序遍历找根，
     * 中序遍历找左右子树，
     * 关于我前中后序遍历，可以去找我以前写过的。
     * @return: LeetCode.TreeNode
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                int[] post_left = Arrays.copyOfRange(postorder, 0, i);
                int[] post_right = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(in_left, post_left);
                root.right = buildTree(in_right, post_right);
                break;
            }
        }
        return root;
    }
}
