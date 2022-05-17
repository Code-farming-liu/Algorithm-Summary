package zuoshendata.zuoshen4.basic.class05;

/**
 * @ClassName: 搜索二叉树
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/16 17:48
 **/

public class 搜索二叉树 {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }

        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2.right != null && cur2.right != cur1) {
                cur2 = cur2.right;
            }
            if (cur2.right == null) {
                cur2.right = cur1;
                cur1 = cur1.left;
                continue;
            } else {
                cur2.right = null;
            }
        }
        return false;
    }
}