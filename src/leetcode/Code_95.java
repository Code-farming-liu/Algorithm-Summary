package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Code_95
 * @Description: 不同的二叉搜索树II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 * @Author: Admin
 **/

public class Code_95 {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
    }


    private static TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }


    public static List<TreeNode> generateTrees1(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    //回溯生成所有根节点值在[start, end]间的树
    public static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();
        //此时应该生成空节点
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        //对每个值为i的根节点，其左右子树的根节点的值分别在[start, i - 1]和[i + 1, end]范围内
        for(int i = start; i <= end; i++){
            //递归生成所有可能的二叉搜索左右子树
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            //枚举所有左右子树的组合生成合法的二叉搜索树
            for(TreeNode left: leftTrees){
                for(TreeNode right: rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        generateTrees1(3);
    }
}