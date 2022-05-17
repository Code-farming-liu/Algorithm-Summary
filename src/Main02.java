import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Main02
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/29 19:47
 **/

public class Main02 {

    public static int searchTree(int[] treeNodes, int k) {
        // write code here
        if (k > treeNodes.length) {
            return 0;
        }
        Node root = getTree(treeNodes);
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0, k);
        Collections.sort(res);
        return res.get(res.size() - k);
    }

    public static void dfs(List<Integer> res, Node root, int cur, int k) {
        if (root == null) {
            return;
        }
        if (root.val != 0) {
            cur += root.val;
            res.add(cur);
        }
        dfs(res, root.left, cur, k);
        dfs(res, root.right, cur, k);
    }

    public static Node getTree(int[] nums) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], null, null);
            list.add(node);
        }
        for (int i = 0; i < nums.length; i++) {
            if (2 * i + 1 < nums.length) {
                list.get(i).left = list.get(2 * i + 1);
            }
            if (2 * i + 2 < nums.length) {
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -9, -8};
        System.out.println(searchTree(nums, 1));
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}