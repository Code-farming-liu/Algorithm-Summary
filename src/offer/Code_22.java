package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName: Test21
 * @Description: 从上往下打印矩阵
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author: Admin
 **/

public class Code_22 {
    /**
     * @param root
     * @Author: Admin
     * @Description: 思路描述：
     * 我们在解这道题之前我们首先需要去了解一个算法 层次遍历
     *
     * 图的广度优先搜索(Broad First Search) 。
     * 类似于一个分层搜索的过程，广度优先遍历需要使用一个队列以保持访问过的结点的顺序，
     * 以便按这个顺序来访问这些结点的邻接结点
     *
     * 广度优先遍历算法步骤
     *
     * 访问初始结点v并标记结点v为已访问。
     * 结点v入队列
     * 当队列非空时，继续执行，否则算法结束。
     * 出队列，取得队头结点u。
     * 查找结点u的第一个邻接结点w。
     * 若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
     *  6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
     *  6.2 结点w入队列
     *  6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。
     * 我们可以直接使用层次遍历解决
     * @return: java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                res.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}