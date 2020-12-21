package offer;

import java.util.Stack;

/**
 * @ClassName: Test18
 * @Description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @Author: Admin
 **/

public class Code_18 {
    /**
     * @Author: Admin
     * @Description: 思路描述：
     * 我们根据图中的结果可以看出其特点
     *
     * 左子树的左节点 与 右子树的右节点 进行交换
     *
     * 左子树的 右节点 与 右子树的左节点 进行交换
     *
     * 首先我们将对应左右节点压入栈中，然后对应的进行交换，这样解释起来较为抽象 下面利用图解方式来进行。
     *
     * 	    8
     * 	   /  \
     * 	  6   10 经过调换左右子树之后
     * 	 / \  / \
     * 	5  7 9 11
     *
     * 	    8
     * 	   /  \
     * 	 10    6 调换左右子树的节点
     * 	 / \   / \
     * 	9 11   5  7
     *
     * 	    8
     * 	   /  \
     * 	  10   6
     * 	 / \  / \
     * 	11 9 7  5
     * @param root
     * @return: void
     */
    public void Mirror(TreeNode root) {
        if(root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
    }
}