import java.util.ArrayList;

/**
 * @ClassName: Test23
 * @Description: 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @Author: Admin
 **/

public class Test23 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root, target, new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode root, int target, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        } else {
            //遍历左子树
            dfs(root.left,target, list);
            dfs(root.right,target,list);
        }
        list.remove(list.size() - 1);

    }
}