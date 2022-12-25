package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的真二叉树
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 *
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 *
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：[[0,0,0]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 *
 */
public class Code_894 {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        dfs(res, n, new TreeNode(0));
        return res;
    }
    public TreeNode dfs(List<TreeNode> res, int n, TreeNode root) {
        if (n == 0) {
            res.add(root);
            return new TreeNode(0);
        }
        root.left = dfs(res, n - 1, root);
        root.right = dfs(res, n - 1, root);
        return root;
    }
}
