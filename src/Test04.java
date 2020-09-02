import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: Test04
 * @Description: 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author: Admin
 **/

public class Test04 {
    //使用stack辅助实现
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
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
