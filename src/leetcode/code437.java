package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class code437 {
    Integer res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> path = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                path.add(root);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        int a = 0;
        for (int i = 0; i < path.size(); i++) {
            int d = sum(path.get(i), targetSum);
            a += d;
        }
        return a;
    }

    public int sum(TreeNode root, int targetSum) {
        res = 0;
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, long target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        if (target == 0) {
            res++;
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }

    public static void main(String[] args) {
        long a = 0;
        System.out.println(a-1000000000-1000000000-294967296-1000000000-1000000000);
    }
}
