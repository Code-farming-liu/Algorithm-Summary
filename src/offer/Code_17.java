package offer;

/**
 * @ClassName: Test17
 * @Description: 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @Author: Admin
 * @Date 2020/9/3 11:43
 **/

public class Code_17 {
    /**
     * @param root1
     * @param root2
     * @Author: Admin
     * @Description: 思路描述
     * 我们首先分为几种情况考虑：
     * 1.根节点相同 root1.val == root2.val ，
     *  1.1 判断对应的子树节点的值是否相同
     *  1.2 如果root2遍历完成，证明匹配成功 返回 true
     *  1.3 如果root1为null，并且root2不为null 证明匹配失败，返回false
     *  1.4 不断递归遍历比较，
     * root1的左子树与root2的左子树，
     * root1的右子树与root2的右子树
     * 2. 根节点不同，那么我们就没办法，只能分别去比较
     *  root1的左子树中是否包含root2;
     *  root1的右子树中是否包含root2
     *  包含则返回true，否则false
     * @return: boolean
     */
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