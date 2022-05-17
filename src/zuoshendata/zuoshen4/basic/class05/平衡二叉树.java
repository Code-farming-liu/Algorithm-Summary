package zuoshendata.zuoshen4.basic.class05;

/**
 * @ClassName: 平衡二叉树
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/16 15:09
 **/

public class 平衡二叉树 {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class ReturnData {
        private boolean isB;
        private int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }

        public static ReturnData process(Node head) {
            if (head == null) {
                return new ReturnData(false, 0);
            }
            ReturnData leftData = process(head.left);
            if (!leftData.isB) {
                return new ReturnData(false, 0);
            }
            ReturnData rightData = process(head.right);
            if (!rightData.isB) {
                return new ReturnData(false, 0);
            }
            int abs = Math.abs(leftData.h - rightData.h);
            if (abs > 1) {
                return new ReturnData(false, 0);
            }
            return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
        }


        public static boolean isB(Node head) {
            return process(head).isB;
        }

    }

    public static boolean isBalance(Node head) {
        return false;
    }

}