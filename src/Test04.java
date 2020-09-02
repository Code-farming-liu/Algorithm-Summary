import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: Test04
 * @Description: 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @Author: Admin
 **/

public class Test04 {
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
}