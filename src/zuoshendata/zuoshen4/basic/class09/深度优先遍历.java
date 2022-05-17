package zuoshendata.zuoshen4.basic.class09;

import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName: 深度优先遍历
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 16:28
 **/

public class 深度优先遍历 {
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}