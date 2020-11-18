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

public class Test79 {
    //先遍历 将所有的节点保存在 map中 然后在进行连线
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
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        // 复制
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = new Node(cur.val, null, null );
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
}
