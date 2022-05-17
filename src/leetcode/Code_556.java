package leetcode;

/**
 * @ClassName: Code_556
 * @Description: 下一个更大的元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 *
 * @Author: Admin
 **/

public class Code_556 {
    public static int nextGreaterElement(int n) {
        if (n < 10) {
            return -1;
        }
        String str = n + "";
        char[] chars = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        while (i >= 0 && chars[i + 1] <= chars[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        } else {
            int j = length - 1;
            while (j >= 0 && chars[i] >= chars[j]) {
                j--;
            }
            swap(chars, i, j);
        }
        reverse(chars, i + 1);
        try {
            return Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return -1;
        }

    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void reverse(char[] chars, int start) {
        int left = start, right = chars.length - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(230241));
    }
}