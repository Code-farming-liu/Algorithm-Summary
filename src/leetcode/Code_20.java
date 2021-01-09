package leetcode;

import java.util.Stack;

/**
 * @ClassName: Code_20
 * @Description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * @Author: Admin
 **/

public class Code_20 {
    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 这道题我们首先先创建一个栈 用于保存右括号，
     * 这里我们首先可以 判断 括号的总个数，如果总个数是奇数，那么这个就肯定不是有效的括号，
     * 接下来我们再来判断，如果是左括号，我们要想变成有效的的括号，那么必须得压入右括号，
     * 如果这个条件不满足，那么证明不是左括号，我们发现栈是空的 或者 栈顶弹出的括号 不等于当前的字符（因为 如果不等于当前的括号，证明他没有左括号），
     * 那么证明当前的 结果不是一个有效的括号
     * @return: boolean
     */
    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}