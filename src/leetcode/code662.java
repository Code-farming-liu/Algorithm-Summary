package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 *
 * 树的 最大宽度 是所有层中最大的 宽度 。
 *
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 *
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 *
 *
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 *
 *
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 *
 *
 * 提示：
 *
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 */
class pair {
    TreeNode root;
    int index;

    public pair(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}

public class code662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<pair> queue = new ArrayList<>();
        queue.add(new pair(root, 1));
        int res = 0;
        while (queue.size() > 0) {
            res = Math.max(res, queue.get(queue.size()-1).index - queue.get(0).index + 1);
            int size = queue.size();
            List<pair> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                pair pair = queue.get(i);

                if (pair.root.left != null) {
                    temp.add(new pair(pair.root.left, pair.index * 2));
                }

                if (pair.root.right != null) {
                    temp.add(new pair(pair.root.right, pair.index * 2 + 1));
                }
            }
            queue = temp;
        }
        return res;
    }
}
