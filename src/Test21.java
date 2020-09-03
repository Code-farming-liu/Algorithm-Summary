import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName: Test21
 * @Description: 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @Author: Admin
 * @Date 2020/9/3 15:11
 **/

public class Test21 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.remove();
                res.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}