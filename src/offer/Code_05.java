package offer;

import java.util.Stack;

/**
 * @ClassName: Test06
 * @Description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Author: Admin
 **/

public class Code_05 {

    /**
     * @Author Admin
     * @Description: 思路分析：
     * 我们做这道题，首先先来了解了解 栈 和 队列的 区别
     * 栈： 先进后出
     * 队列：先进先出
     * 他们就是一个顺序，一个逆序，我们可以使用两个逆序实现一个顺序，因此很容易可以想到解题思路。
     * 将数据添加到stack1，然后将stack1中的数据弹出，压入stack2，将stack2中的数据弹出
     * 如果stack1不为null，则一直弹出，并压入stack2中
     * 如果stack2不为null，则一直弹出，并压入stack1中
     * @param null
     * @return
     **/
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //压栈
    public void push(int node) {
        stack1.push(node);
    }

    //stack1出栈，并压入stack2中
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        //stack2出栈，并压入stack1中
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
}
