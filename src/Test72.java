/**
 * @ClassName: Test72
 * @Description: 验证二叉搜索树
 *给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @Author: Admin
 **/

public class Test72 {
    private Integer tempVal = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (tempVal != null && tempVal >= root.val) {
            return false;
        }

        tempVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }

        return true;
    }

    Integer preValue = null;
    public boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        //如果左子树是二叉搜索树再继续搜索右子树，如果不是则直接返回
        if(isValidBST(root.left)){
            if(preValue != null && preValue >= root.val){
                return false;
            }
            preValue = root.val;
            return isValidBST(root.right);
        }
        return false;
    }
}