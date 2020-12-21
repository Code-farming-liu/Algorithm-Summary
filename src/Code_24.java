import java.util.ArrayList;

/**
 * @ClassName: Test23
 * @Description: 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author: Admin
 **/

public class Code_24 {
    /**
     * @Author: Admin
     * @Description: 思路描述:
     * 我们首先来了解下 深度优先遍历
     *
     * 图的深度优先搜索(Depth First Search) 。
     * 深度优先遍历，从初始访问结点出发，初始访问结点可能有多个邻接结点，
     * 深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，
     * 访问它的第一个邻接结点， 可以这样理解：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
     * 我们可以看到，这样的访问策略是优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。
     * 显然，深度优先搜索是一个递归的过程
     *
     * 深度优先遍历算法步骤
     * 1.访问初始结点v，并标记结点v为已访问。
     * 2.查找结点v的第一个邻接结点w。
     * 3.若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
     * 4.若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
     * 5.查找结点v的w邻接结点的下一个邻接结点，转到步骤3。
     *
     * 我们深度优先遍历整个树，将对应的节点的值加入到集合中，
     * 递归过程中使用target 减去 节点的值，
     * 最终到达叶子节点，判断该target是否为0
     * 不为0则回溯 继续遍历
     * 为0 则为一条路径
     * @param null
     * @return: null
     */
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            //遍历左子树
            dfs(root.left, target, list);
            dfs(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}