package leetcode;

public class code_988 {
    String res = "~";

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }

        dfs(root, new StringBuilder());
        return res.equals("~") ? "" : res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String rs = sb.toString();
            sb.reverse();

            if (res.compareTo(rs) > 0) {
                res = rs;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
