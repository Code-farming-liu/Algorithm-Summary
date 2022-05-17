package zuoshendata.zuoshen4.basic.class05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 完全二叉树
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/16 20:39
 **/

public class 完全二叉树 {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            boolean is = (leaf && (left != null || right != null))
                    || (left == null && right != null);
            if (is) {
                return false;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null && right == null) {
                leaf = true;
            }
//            if (left != null) {
//                queue.add(left);
//            }
//            if (right != null) {
//                queue.add(right);
//            } else {
//                leaf = true;
//            }
        }
        return true;
    }
}