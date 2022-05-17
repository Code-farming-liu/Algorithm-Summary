package zuoshendata.zuoshen4.basic.class04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 复制随机链表
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/15 21:24
 **/

public class 复制随机链表 {
    public static class Node {
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
        }
    }


    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        Set<Integer> set = new HashSet<>();

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}