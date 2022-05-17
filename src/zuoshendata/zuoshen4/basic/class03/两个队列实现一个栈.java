package zuoshendata.zuoshen4.basic.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 两个队列实现一个栈
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 20:13
 **/

public class 两个队列实现一个栈 {

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public 两个队列实现一个栈() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int num) {
        queue.add(num);
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("栈空");
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
    }


}