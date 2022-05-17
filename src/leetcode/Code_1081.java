package leetcode;

import java.util.Stack;

/**
 * @ClassName: Code_1081
 * @Description: 不同字符的最小子序列
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 *
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 *
 * @Author: Admin
 **/

public class Code_1081 {
    public String smallestSubsequence(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > chars[i] && lastIndex[stack.peek() - 'a'] > i) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
            }
            stack.push(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}