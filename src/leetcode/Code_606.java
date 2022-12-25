package leetcode;

/**
 * 根据二叉树创建字符串
 * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 * <p>
 * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4]
 * 输出："1(2(4))(3)"
 * 解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出："1(2()(4))(3)"
 * 解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。
 */
public class Code_606 {
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return "";
        }
        dfs(root, res);
        return res.toString().substring(1, res.length() - 1);
    }

    public void dfs(TreeNode root, StringBuilder res) {
        res.append("(");
        res.append(root.val);
        if (root.left != null) {
            dfs(root.left, res);
        } else if (root.right != null) {
            res.append("()");
        }
        if (root.right != null) {
            dfs(root.right, res);
        }
        res.append(")");
    }
}
