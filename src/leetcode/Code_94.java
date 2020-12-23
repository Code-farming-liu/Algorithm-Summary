package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Test71
 * @Description: 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author: Admin
 **/

public class Code_94 {
    //最简单的递归遍历

    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 最为简单的递归遍历 用一个辅助方法 根据 左根右
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    //    利用栈 先进后出 当遍历到叶子结点 然后 将对应的叶子结点 加入到集合并出栈。

    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 基于栈的遍历：
     * 判断当前节点是不是叶子节点，如果是将当前节点的值则直接加入集合 并出栈，
     * 不是叶子节点 遍历右子树，否则加入栈中。
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    //方法三 ： 莫里斯遍历

    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 莫里斯遍历 的基本思想
     * 假设当前节点为cur，并且开始时赋值为根节点root。
     * 判断cur节点是否为空
     * 如果不为空
     * 1）如果cur没有左孩子，cur向右更新，即（cur = cur.right）
     * 2）如果cur有左孩子，则从左子树找到最右侧节点pre
     * 如果pre的右孩子为空，则将右孩子指向cur。pre.right = cur
     * 如果pre的右孩子为cur，则将其指向为空。pre.right = null。（还原树结构）
     * cur为空时，停止遍历
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;//当前节点的前驱节点
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost // 寻找到左子树的右叶子节点
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node  //将原来的节点连接到左子树的右叶子结点
                TreeNode temp = curr; // store cur node //临时保存当前的节点
                curr = curr.left; // move cur to the top of the new tree //将其继续看左子树有是否还满足条件
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }
}