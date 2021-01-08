package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test74
 * @Description: 从前序与中序遍历序列构造二叉树
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

    /**
     * @param preorder
     * @param inorder
     * @Author: Admin
     * @Description: 我们并不需要将对应的 前中序数组分开，我们可以使用指针的缩减，来达到相同的目的。
     * @return: leetcode.TreeNode
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        // 如果前序遍历的结果为空 直接返回。
        if (pre_start == pre_end) {
            return null;
        }
        // 根据前序遍历的第一个节点作为根节点
        int rootVal = preorder[pre_start];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历中的根节点的坐标
        int index = 0;
        for (int i = in_start; i < in_end; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        // 根节点的左子树有多少个子节点
        int left = index - in_start;
        root.left = buildTreeHelper(preorder, pre_start + 1, pre_start + left + 1, inorder, in_start, index);
        root.right = buildTreeHelper(preorder, pre_start + left + 1, pre_end, inorder, index + 1, in_end);
        return root;
    }

    /**
     * @param preorder
     * @param inorder
     * @Author: Admin
     * @Description: 对上一一种算法的优化，使用对应的map保存了中序数组中的下标，省的去遍历查找根节点了。
     * @return: leetcode.TreeNode
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将对应的中序数组中的下标加入到hash表中
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper1(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper1(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end,
                                      Map<Integer, Integer> map) {
        // 如果前序遍历的结果为空 直接返回。
        if (pre_start == pre_end) {
            return null;
        }
        // 根据前序遍历的第一个节点作为根节点
        int rootVal = preorder[pre_start];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历中的根节点的坐标
        int index = map.get(rootVal);
        // 根节点的左子树有多少个子节点
        int left = index - in_start;
        root.left = buildTreeHelper1(preorder, pre_start + 1, pre_start + left + 1, inorder, in_start, index, map);
        root.right = buildTreeHelper1(preorder, pre_start + left + 1, pre_end, inorder, index + 1, in_end, map);
        return root;
    }

}
