package zuoshendata.zuoshen4.basic.class09;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 宽度优先遍历
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 16:19
 **/

public class 宽度优先遍历 {
    // 从 node节点出发，进行宽度优先遍历
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}