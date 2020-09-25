import java.util.Arrays;

/**
 * @ClassName: Test47
 * @Description: 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author: Admin
 * @Date 2020/9/25 19:27
 **/

public class Test47 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == postorder[postorder.length - 1]) {
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