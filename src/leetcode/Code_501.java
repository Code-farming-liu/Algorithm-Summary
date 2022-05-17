package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_501
 * @Description: 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @Author: Admin
 * @Date 2021/9/23 21:39
 **/

public class Code_501 {
    List<Integer> res = new ArrayList<>();
    int base, count, max;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        dfs(root);
        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        helper(root.val);
        dfs(root.right);
    }

    public void helper(int val) {
        if (val == base) {
            count++;
        } else {
            count = 1;
            base = val;
        }
        if (count == max) {
            res.add(val);
        }
        if (count > max) {
            max = count;
            res.clear();
            res.add(val);
        }
    }
}