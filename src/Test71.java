import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: Test71
 * @Description: 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author: Admin
 * @Date 2020/11/16 10:59
 **/

public class Test71 {
    //最简单的递归遍历
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
    public List< Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList<>();
        Stack< TreeNode > stack = new Stack <> ();
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