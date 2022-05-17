//package leetcode;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName: 剑指Offer35复杂链表的复制
// * @Description:
// * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
// *
// *  
// *
// * 示例 1：
// *
// *
// *
// * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// * 示例 2：
// *
// *
// *
// * 输入：head = [[1,1],[2,1]]
// * 输出：[[1,1],[2,1]]
// * 示例 3：
// *
// *
// *
// * 输入：head = [[3,null],[3,0],[3,null]]
// * 输出：[[3,null],[3,0],[3,null]]
// * 示例 4：
// *
// * 输入：head = []
// * 输出：[]
// * 解释：给定的链表为空（空指针），因此返回 null。
// *  
// *
// * 提示：
// *
// * -10000 <= Node.val <= 10000
// * Node.random 为空（null）或指向链表中的节点。
// * 节点数目不超过 1000 。
// *
// * @Author: Admin
// * @Date 2021/9/24 22:04
// **/
//
//public class 剑指Offer35复杂链表的复制 {
//    public Node copyRandomList(Node head) {
//        Map<Node, Node> map = new HashMap<>();
//        Node cur = head;
//        while (cur != null) {
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }
//
//    public Node copyRandomList(Node head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode cur = head;
//        ListNode next = null;
//        while (cur != null) {
//            next = cur.next;
//            cur.next = new ListNode(cur.val);
//            cur.next.next = next;
//            cur = next;
//        }
//        cur = head;
//        ListNode curCopy = null;
//        while (cur != null) {
//            next = cur.next.next;
//            curCopy = cur.next;
//            curCopy.random = cur.random != null ? cur.random.next : null;
//        }
//        ListNode res = head.next;
//        cur = head;
//        while (cur != null) {
//            next = cur.next.next;
//            curCopy = cur.next;
//            cur.next = next;
//            curCopy.next = next != null ? next.next : null;
//            cur = next;
//        }
//        return res;
//    }
//}