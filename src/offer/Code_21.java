package offer;

import java.util.Stack;

/**
 * @ClassName: Test20
 * @Description: 栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @Author: Admin
 **/

public class Code_21 {
    /**
     * @param pushA
     * @param popA
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以使用一个栈去辅助，将pushA的元素限压入栈中，然后在判断pushB中等于该栈顶的元素
     * 例如 pushA = 1,2,3,4,5 pushB = 4,5,3,2,1
     * 1压入栈 但是B的第一个元素为4 不为 1
     * 因此继续压入栈 2，3, 4
     * 此时满足条件则将 栈中元素出栈 pushB随之下标后移 也即
     * 栈中 1,2,3 ---- 5
     * 不满足继续压入
     * 栈中 1,2,3,5 ----- 5 相等 5出栈
     * 栈中 1,2,3 ------- 3 相等 3出栈
     * 栈中1，2 -------- 2 相等 2出栈
     * 栈中 1 ----------- 1 相等 1出栈
     * 栈空
     *
     * 最后我们只需要判断栈是否为空即可。
     * @return: boolean
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}