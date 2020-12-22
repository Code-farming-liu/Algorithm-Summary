package LeetCode;

import java.util.Arrays;

/**
 * @ClassName: Test74
 * @Description: 从前序与中序遍历构造二叉树
 * * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * *
 * * 注意:
 * * 你可以假设树中没有重复的元素。
 * *
 * * 例如，给出
 * *
 * * 前序遍历 preorder = [3,9,20,15,7]
 * * 中序遍历 inorder = [9,3,15,20,7]
 * * 返回如下的二叉树：
 * *
 * *     3
 * *    / \
 * *   9  20
 * *     /  \
 * *    15   7
 * @Author: Admin
 **/

public class Code_105 {
    /**
     * @param preorder
     * @param inorder
     * @Author: Admin
     * @Description: 我们利用前序序列寻找根节点，中序序列判断 左右节点
     * @return: TreeNode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            //根据前序数组的第一个元素，就可以确定根节点
            if (preorder[0] == inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(pre_left, in_left);
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;
    }
}