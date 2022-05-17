package zuoshendata.zuoshen4.basic.class05;

/**
 * @ClassName: 二叉树的后继遍历
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/14 14:55
 **/

public class 二叉树的后继节点 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode (Node node) {
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
    
    // 找到当前节点右子树的最左节点
    private static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}