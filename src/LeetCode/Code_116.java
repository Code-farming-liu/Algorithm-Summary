package LeetCode;

import java.util.LinkedList;

/**
 * @ClassName: Test75
 * Description: 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * <p>
 * @Author: Admin
 **/

public class Code_116 {
    //效率极低的层次遍历BFS

    /**
     * @param root
     * @Author: Admin
     * @Description: 我们可以层序遍历这个二叉树，然后将同一层的元素进行串联
     * @return: Node
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node temp = queue.removeFirst();
            //将队列中的元素串联起来
            for (int i = 1; i < size; i++) {
                temp.next = queue.get(i);
                temp = queue.get(i);
            }
            //遍历队列中的每一个元素，将每个元素的左右节点叶放入到对列中
            for (int i = 0; i < size; i++) {
                temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            }
        }
        return root;
    }

    /**
     * @param root
     * @Author: Admin
     * @Description: 我们可以迭代 我们要想串联下一层的节点，
     * 那么可以依赖上一层节点的串联，如果上一层串联完毕，
     * 那么 上一层的 右子节点的next 就是 右子树的左子节点
     * @return: Node
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        //循环条件是当前节点的left不为空，当只有根节点
        //或所有叶子节点都串联完后循环就退出了
        while (pre.left != null) {
            Node temp = pre;
            while (temp != null) {
                //将tmp的左右节点都串联起来
                //注:外层循环已经判断了当前节点的left不为空
                temp.left.next = temp.right;
                //如果next 不为空 说明上一层已经串联完毕
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                //继续向右进行遍历 遍历完这一层
                temp = temp.next;
            }
            //继续向下遍历
            pre = pre.left;
        }
        return root;
    }

    //递归 dfs
    //我们以当前节root点为起始，左右节点不断的深入下面，left节点不断往右走，
    // right节点不断往左走，当这两个节点走到底后，整个纵深这段就完成了串联。
    //递归函数实现如下：
    //
    //终止条件:当前节点为空时
    //函数内:以当前节点为起始，完成从上往下的纵深串联，再递归的调用当前节点left和right
    //
    public Node connect2(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        //配合动画演示理解这段，以root为起点，将整个纵深这段串联起来
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归的调用左右节点，完成同样的纵深串联
        dfs(root.left);
        dfs(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;
}