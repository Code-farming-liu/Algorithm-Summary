package leetcode;

/**
 * @ClassName: Code_647
 * @Description: 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @Author: Admin
 **/

public class Code_647 {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSubstrings1(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        int length = s.length();
        boolean[] dp = new boolean[length];
        int count = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j) == s.charAt(i) && (j - i <= 2 || dp[i + 1])) {
                    count++;
                    dp[i] = true;
                } else {
                    dp[i] = false;
                }
            }
        }
        return count;
    }

    int count = 0;
    public int countSubstrings3(String s) {
        int length = s.length();
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            // 回文的长度是奇数
            extendPalindrome(s, i, i);
            // 回文的长度是偶数
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
    }

    public static void main(String[] args) {
        countSubstrings1("countSubstrings3");
    }
}