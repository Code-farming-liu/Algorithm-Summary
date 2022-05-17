package zuoshendata.zuoshen4.basic.class05;

/**
 * @ClassName: 完全二叉树的节点个数
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/16 21:11
 **/

public class 完全二叉树的节点个数 {
    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }
    /**
     * @Author Admin
     * @Description
     * @Date 21:25 2020/12/16
     * @param head 当前节点
     * @param level 当前在第几层
     * @param height 树的高度
     * @return int 以当前节点为父节点，共有多少个节点
     **/
    private static int bs(Node head, int level, int height) {
        if (level == height) {
            return 1;
        }
        // mostLeftLevel(head.right, level + 1) == height  右子树的最左深度到了 最后一层
        if (mostLeftLevel(head.right, level + 1) == height) {
            return (1 << (height - level)) + bs(head.right, level + 1, height);
        } else {
            return (1 << (height - level - 1)) + bs(head.left, level + 1, height);
        }
    }

    private static int mostLeftLevel(Node head, int level) {
        while (head != null) {
            level++;
            head = head.left;
        }
        return level - 1;
    }

}