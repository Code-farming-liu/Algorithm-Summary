package leetcode;

/**
 * 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 *  
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 没有找到删除节点
        if (null == root) {
            return null;
        }
        // 找到删除节点
        if (root.val == key) {
            // 左边为空
            if (null == root.left) {
                return root.right;
            }
            // 右边为null
            if (null == root.right) {
                return root.left;
            }
            TreeNode t = root.left;
            while (null != t.right) {
                t = t.right;
            }
            t.right = root.right;
            return root.left;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 叶子结点
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                // 左不为null 右子树为null
                return root.left;
            } else if (root.left == null && root.right != null) {
                // 左子树为空，右子树不为null
                return root.right;
            } else if (root.left != null && root.right != null) {
                // 左右子树不为null
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode1(root.left, key);
        } else {
            root.right = deleteNode1(root.right, key);
        }
        return root;
    }
}
