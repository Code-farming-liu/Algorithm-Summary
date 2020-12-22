package LeetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test79
 * Description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * @Author: Admin
 **/

public class Code_138 {
    //先遍历 将所有的节点保存在 map中 然后在进行连线

    /**
     * @param head
     * @Author: Admin
     * @Description: 我们可以用三步走来搞定这个问题
     * 第一步，根据遍历到的原节点创建对应的新节点，每个新创建的节点是在原节点后面，
     * 比如下图中原节点1不再指向原原节点2，而是指向新节点1
     * <p>
     * 第二步是最关键的一步，用来设置新链表的随机指针
     * <p>
     * 上图中，我们可以观察到这么一个规律
     * <p>
     * 原节点1的随机指针指向原节点3，新节点1的随机指针指向的是原节点3的next
     * 原节点3的随机指针指向原节点2，新节点3的随机指针指向的是原节点2的next
     * 也就是，原节点i的随机指针(如果有的话)，指向的是原节点j
     * 那么新节点i的随机指针，指向的是原节点j的next
     * <p>
     * 第三步就简单了，只要将两个链表分离开，再返回新链表就可以了
     * @return: LeetCode.Test79.Node
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> lookup = new HashMap<>();
        Node node = head;
        while (node != null) {
            lookup.put(node, new Node(node.val, null, null));
            node = node.next;
        }
        node = head;
        while (node != null) {
            lookup.get(node).next = lookup.get(node.next);
            lookup.get(node).random = lookup.get(node.random);
            node = node.next;
        }
        return lookup.get(head);
    }

    /**
     * @param head
     * @Author: Admin
     * @Description: 使用HashMap 辅助
     *
     * 我们用哈希表来解决这个问题
     * 首先创建一个哈希表，再遍历原链表，遍历的同时再不断创建新节点
     * 我们将原节点作为key，新节点作为value放入哈希表中
     *
     * 第二步我们再遍历原链表，这次我们要将新链表的next和random指针给设置上
     *
     * 从上图中我们可以发现，原节点和新节点是一一对应的关系，所以
     *
     * map.get(原节点)，得到的就是对应的新节点
     * map.get(原节点.next)，得到的就是对应的新节点.next
     * map.get(原节点.random)，得到的就是对应的新节点.random
     * 所以，我们只需要再次遍历原链表，然后设置：
     * 新节点.next -> map.get(原节点.next)
     * 新节点.random -> map.get(原节点.random)
     * 这样新链表的next和random都被串联起来了
     * 最后，我们然后map.get(head)，也就是对应的新链表的头节点，就可以解决此问题了。
     * @return: LeetCode.Test79.Node
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        // 复制
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = new Node(cur.val, null, null);
            cur.next.next = tmp;
            cur = tmp;
        }
        // 置随机指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 拆分
        cur = head;
        Node copy_head = cur.next;
        Node copy_cur = copy_head;
        while (copy_cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;

            copy_cur.next = copy_cur.next.next;
            copy_cur = copy_cur.next;
        }
        // 结束标志null
        cur.next = null;
        return copy_head;
    }

    public static class Node {
        int val;
        LeetCode.Node left;
        LeetCode.Node right;
        Node next;
        Node random;

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
