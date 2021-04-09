package leetcode;

/**
 * @ClassName: Code_392
 * @Description: 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 *
 * @Author: Admin
 **/

public class Code_392 {
    /**
     * @Author: Admin
     * @Description:
     * 首先，我们使用双指针利用 i 和 j 进行判断，
     *
     * 如果 s字符串的字符与t的字符串字符相等，那么两个指针同时向后移动，i++, j++
     *
     * 否则 j++
     *
     * 最后判断 i 是不是等于子串的长度即可
     * @param s
     * @param t
     * @return: boolean
     */
    public static boolean isSubsequence1(String s, String t) {
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    /**
     * @Author: Admin
     * @Description:
     * 考虑前面的双指针的做法，我们注意到我们有大量的时间用于在 t 中找到下一个匹配字符。
     *
     * 这样我们可以预处理出对于 t 的每一个位置，从该位置开始往后每一个字符第一次出现的位置。
     *
     * 我们可以使用动态规划的方法实现预处理，令 f[i] [j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置。在进行状态转移时，
     * 如果 t中位置 i 的字符就是 j，那么 f[i] [j]=i，
     * 否则 j 出现在位置 i+1 开始往后，即 f[i] [j]=f[i+1] [[j]，因此我们要倒过来进行动态规划，从后往前枚举 i。
     *
     * f[i][j] = i      t[i] = j
     * f[i][j] = f[i + 1][j]        t[i] != j
     *
     * 假定下标从 0 开始，那么 f[i] [j] 中有  ，对于边界状态 f[m-1] […]，我们置 f[m] [..] 为 m，让 f[m-1] [..]
     * 正常进行转移。这样如果 f[i] [j]=m，则表示从位置 i 开始往后不存在字符 j。
     *
     * 这样，我们可以利用 f 数组，每次 O(1) 地跳转到下一个位置，直到位置变为 m 或 s 中的每一个字符都匹配成功。
     * @param s
     * @param t
     * @return: boolean
     */
    public static boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][26];
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (i == n) {
                    dp[i][j] = n;
                } else if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (dp[index][s.charAt(i) - 'a'] == n) {
                return false;
            }
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}