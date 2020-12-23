package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Code_316
 * @Description: 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * @Author: Admin
 **/

public class Code_316 {
    /**
     * @Author Admin
     * @Description
     * 思路描述：
     * 我们首先需要知道一般来说字典序升序排序都是比较小的，字符出现一次的一定需要
     * 我们可以使用一个栈，如果栈中没有元素那么直接添加进入栈中，如果当前的栈不为空，
     * 并且当前栈顶的元素 大于当前的值 并且在之后还会继续出现，那么我们就可以去舍弃栈中的元素
     * 例如 栈中 为 b  当前元素为 a ------------ab的字典序小于ba的字典序。
     * 最后将栈中的元素从底向上依次遍历输出即可
     * @param s 目标字符串
     * @return java.lang.String
     **/
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastInx = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastInx[chars[i] - 'a'] = i; //记录每个元素最后一次出现的位置
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26]; //某一个字符是否在栈中出现
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) { //如果出现舍弃当前字符
                continue;
            }
            //当前字符在栈顶元素之前，且栈顶元素在后面还有
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                Character c = stack.removeLast();  //移除栈顶元素
                visited[c - 'a'] = false; //表示该字符没有在栈中出现
            }
            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
} 
