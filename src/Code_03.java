import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: Code_03
 * @Description: 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author: Admin
 **/

public class Code_03 {
    //使用stack辅助实现
    /**
     * @Author Admin
     * @Description 思路描述 ：
     * 我们可以使用stack数据结构辅助遍历，
     * 如果链表不为空则将节点加入到栈中，将全部的节点加入栈中
     * 如果栈不为null则将弹出的节点的值加入到list集合中，从而实现反向遍历。
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     **/
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //先反转 后遍历
    /**
     * @Author Admin
     * @Description 思路描述 2：
     * 我们可以将整个链表反转，反转之后在将正序遍历该链表，实现反转 。
     * @param listNode
     * @return java.util.ArrayList<java.lang.Integer>
     **/
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode pre = null;
        ListNode curr = listNode;
        while(curr != null) {
            //保存当前节点的下一个节点
            ListNode temp = curr.next;
            //断开连接，并将节点加入到pre的前面
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        while(pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }
}
