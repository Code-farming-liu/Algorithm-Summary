package codeTop_backed;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code_199
 * @Description: 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 通过次数112,752提交次数173,805
 *
 * @Author: Admin
 * @Date 2021/6/13 17:03
 **/

public class Code_199 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView1(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }


    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}