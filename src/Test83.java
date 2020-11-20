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

public class Test83 {
    //中缀表达式的计算
    public int evalRPN(String[] tokens) {
        String str = "";
        for (String token : tokens) {
            str += token;
        }
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            ch = str.substring(index, index + 1).charAt(0);
            if (isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (priority(ch) <= priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = cal(num1, num2, oper);

                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                keepNum += ch;
                if (index == str.length()) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (isOper(str.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= str.length()) {
                break;
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(res);
        }
        return res;
    }

    //判断是否是符号
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '/' || val == '*';
    }

    //根据符号如何计算
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //由于是栈 栈底 - 栈顶
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//由于是栈 栈底 / 栈顶
                break;
            default:
                break;
        }
        return res;
    }

    //确定运算符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '-') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }

    }
    //利用栈 遇到数字直接入栈， 否则 弹出两个数字 进行运算
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