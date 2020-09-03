/**
 * @ClassName: Test17
 * @Description: 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author: Admin
 * @Date 2020/9/3 11:43
 **/

public class Test17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //建立标志
        boolean res = false;
        if (root1 != null && root2 != null) {
            //根节点相同 比较左右子树是否相同 root1中是否包含root2
            if (root1.val == root2.val) {
                res = isHave(root1, root2);
            }
            //证明根节点不同职能分别比较root1的左右子树是否包含额该子树
            if (!res) {
                res = HasSubtree(root1.left, root2);
            }
            if (!res) {
                res = HasSubtree(root1.right, root2);
            }

        }
        return res;

    }

    //当根节点相同 判断对应的左右子树 是否相同 匹配
    public boolean isHave(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        //匹配成功
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isHave(root1.left, root2.left) &&
                isHave(root1.right, root2.right);
    }
}