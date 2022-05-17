package codeTop_backed;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_113
 * @Description: 路径总和
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @Author: Admin
 * @Date 2021/6/13 18:12
 **/

public class Code_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, ArrayList<Integer> list, int cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null && cur == targetSum) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, targetSum, res, list, cur);
        dfs(root.right, targetSum, res, list, cur);
        list.remove(list.size() - 1);
    }
}