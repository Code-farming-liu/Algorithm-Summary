import java.util.Stack;

/**
 * @ClassName: Test06
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/9/2 14:50
 **/

public class Test06 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //压栈
    public void push(int node) {
        stack1.push(node);
    }

    //stack1出栈，并压入stack2中
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        //stack2出栈，并压入stack1中
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
}