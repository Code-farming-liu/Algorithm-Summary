package leetcode;

// https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-shu-d-eupu/
public class Code_671 {
    int res = -1;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.val != cur) {
            if (res == -1) {
                res = root.val;
            } else {
                res = Math.min(root.val, res);
            }
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
