import java.util.Stack;

/**
 * @ClassName: Test93
 * Description: 基本计算器II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * <p>
 * @Author: Admin
 **/

public class Test93 {
    public int calculate(String s) {
        s.trim();
        Stack<Character> operStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (index >= s.length()) {
            ch = s.substring(index, index + 1).charAt(0);
            if (ch == ' ') {
                continue;
            }
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
                if (index == s.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (isOper(s.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
        }
        while (operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = cal(num1, num2, oper);
            numStack.push(res);
        }
        return res;
    }

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;//res 用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
//                if (num1 < num2) {
//                    res = num2 - num1;
//                }
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    //先跳过空格
    //出现了数字则记录整个数字是多少，然后根据之前的运算符决定下一步：
    //如果是加号'+'，说明前面的运算独立于以后的运算，可以将结果暂时放入栈；
    //如果是减号'-'，可以看成-1 * tempNum，然后将-tempNum入栈；
    //如果是乘号'*'或者除号'/'，由于前面的运算独立于此，可以先计算lastNum和tempNum积，然后结果入栈。
    //最后将栈中的所有元素相加就是答案。
    public int calculate1(String s) {
        Stack<Integer> numStack = new Stack<>();

        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }

            if (Character.isDigit(arr[i])) {
                int tempNum = arr[i] - '0';
                while (++i < arr.length && Character.isDigit(arr[i])) {
                    tempNum = tempNum * 10 + (arr[i] - '0');
                }
                i--;

                if (lastOp == '+') {
                    numStack.push(tempNum);
                } else if (lastOp == '-') {
                    numStack.push(-tempNum);
                } else {
                    numStack.push(res(lastOp, numStack.pop(), tempNum));
                }
            } else {
                lastOp = arr[i];
            }
        }

        int ans = 0;
        for (int num : numStack) {
            ans += num;
        }
        return ans;
    }

    private int res(char op, int a, int b) {
        if (op == '*') {
            return a * b;
        } else if (op == '/') {
            return a / b;
        } else if (op == '+') {
            //其实加减运算可以忽略
            return a + b;
        } else {
            return a - b;
        }
    }
}