package offer;

import java.util.Arrays;

/**
 * @ClassName: Test05
 * @Description: 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * @Author: Admin
 **/

public class Code_04 {
    /**
     * @Author Admin
     * @Description： 思路描述
     * 我们在做这道题之前，我们需要有一定的理论基础，我们利用前序中序构建一颗二叉树，
     * 我们先理论构建，再去代码实现。我们需要记住前序找根，中序找左右，记住这点我们便可以做出来此题。
     *
     * 根据前序数组的第一个元素，就可以确定根节点
     * 在中序数组中找到该元素，该元素的左半部分，即为左子树；右半部分，即为右子树。
     * 将前序数组分成左右两半，再将中序数组分成左右两半
     * 之后递归的处理前序数组的左边部分和中序数组的左边部分
     * 递归处理前序数组右边部分和中序数组右边部分
     * @param pre
     * @param in
     * @return TreeNode
     **/
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < pre.length; i++){
            //根据前序数组的第一个元素，就可以确定根节点
            if(pre[0] == in[i]){
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(pre, 1, i + 1);
                int[] pre_right = Arrays.copyOfRange(pre,i + 1, pre.length);
                int[] in_left = Arrays.copyOfRange(in,0,i);
                int[] in_right = Arrays.copyOfRange(in,i + 1,in.length);
                root.left = reConstructBinaryTree(pre_left,in_left);
                root.right = reConstructBinaryTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }
}