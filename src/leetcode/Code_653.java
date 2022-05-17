package leetcode;

import java.util.HashSet;
import java.util.Set;

// 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
// 
//
//示例 1：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
//示例 2：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
//提示:
//
//二叉树的节点个数的范围是  [1, 104].
//-104 <= Node.val <= 104
//root 为二叉搜索树
//-105 <= k <= 105
//
public class Code_653 {

    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
