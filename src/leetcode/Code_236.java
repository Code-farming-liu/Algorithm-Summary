package leetcode;

/**
 * @ClassName: Test95
 * Description: 二叉树最近的公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * @Author: Admin
 **/

public class Code_236 {
    /**
     * @param root
     * @param p
     * @param q
     * @Author: Admin
     * @Description: 思路描述：
     * 从根节点开始遍历树。
     * 如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
     * 如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
     * 如果在遍历的任何点上，left、right 或者 mid 三个标记中的任意两个变为 true，
     * 这意味着我们找到了节点 p 和 q 的最近公共祖先。
     * @return: LeetCode.TreeNode
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果根节点为null
        if (root == null) {
            return null;
        }
        // 如果他俩其中一个是根节点
        if (p == root || q == root) {
            return root;
        }
        // 假设 left 以及 right 都是已经算出结果的
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果left为null,则必定在右边
        if (left == null) {
            return right;
        }
        // 如果right为null,则必定在左边
        if (right == null) {
            return left;
        }
        // 如果都不为null,那就是在两边,所以返回root即可
        return root;
    }
} 
