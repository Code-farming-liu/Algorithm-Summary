package leetcode;

import java.util.Stack;

/**
 * @ClassName: Test83
 * Description: 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p> 
 * @Author: Admin
 **/

public class Code_150 {

    //利用栈 遇到数字直接入栈， 否则 弹出两个数字 进行运算

    /**
     * @param tokens
     * @Author: Admin
     * @Description: 直接使用栈来进行求值，判断 如果是数字直接入栈，是符号
     * 则弹出两个数字进行求解 将结果入栈，到了最后 栈中只有一个结果那么这个结果就是 最终的结果
     * @return: int
     */
    public int evalRPN1(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("\\d+") || token.matches("[-]?\\d+")) {
                stack.push(token);
            } else {
                if (!stack.isEmpty()) {
                    int num1 = Integer.parseInt(stack.pop());
                    int num2 = Integer.parseInt(stack.pop());
                    int res = 0;
                    if (token.equals("+")) {
                        res = num1 + num2;
                    } else if (token.equals("-")) {
                        res = num2 - num1;
                    } else if (token.equals("*")) {
                        res = num2 * num1;
                    } else if (token.equals("/")) {
                        res = num2 / num1;
                    } else {
                        throw new RuntimeException("输入有误");
                    }
                    stack.push(res + "");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * @param tokens
     * @Author: Admin
     * @Description:
     *
     * 同样的思路 然后用纯数组方式实现（推荐）
     * @return: int
     */
    public static int evalRPN4(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    // numStack[index++] = Integer.valueOf(s);
                    //valueOf改为parseInt，减少自动拆箱装箱操作
                    numStack[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return numStack[0];
    }

    // 栈实现   8 ms	36.7 MB
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }
}
