package leetcode;

/**
 * @ClassName: Code_10
 * @Description: 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 * @Author: Admin
 **/

public class Code_10 {
    /**
     * @Author: Admin
     * @Description:
     *
     * 以一个例子详解动态规划转移方程：
     * S = abbbbc
     * P = ab*d*c
     * 1. 当 i, j 指向的字符均为字母（或 '.' 可以看成一个特殊的字母）时，
     *    只需判断对应位置的字符即可，
     *    若相等，只需判断 i,j 之前的字符串是否匹配即可，转化为子问题 f[i-1][j-1].
     *    若不等，则当前的 i,j 肯定不能匹配，为 false.
     *
     *        f[i-1][j-1]   i
     *             |        |
     *    S [a  b  b  b  b][c]
     *
     *    P [a  b  *  d  *][c]
     *                      |
     *                      j
     *
     *
     * 2. 如果当前 j 指向的字符为 '*'，则不妨把类似 'a*', 'b*' 等的当成整体看待。
     *    看下面的例子
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    注意到当 'b*' 匹配完 'b' 之后，它仍然可以继续发挥作用。
     *    因此可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j]:
     *
     *          i
     *          | <--
     *    S  a [b] b  b  b  c
     *
     *    P  a [b  *] d  *  c
     *             |
     *             j
     *
     *    另外，也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。
     *    转化为子问题 f[i][j-2]:
     *
     *             i
     *             |
     *    S  a  b [b] b  b  c
     *
     *    P [a] b  *  d  *  c
     *       |
     *       j <--
     *
     * 3. 冗余的状态转移不会影响答案，
     *    因为当 j 指向 'b*' 中的 'b' 时, 这个状态对于答案是没有用的,
     *    原因参见评论区 稳中求胜 的解释, 当 j 指向 '*' 时,
     *    dp[i][j]只与dp[i][j-2]有关, 跳过了 dp[i][j-1].
     * @param s
     * @param p
     * @return: boolean
     */
    public static boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        isMatch(s, p);
    }

    public static boolean isMatch2(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int[][] visit = new int[len1][len2];
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean flag = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) ||(flag && isMatch(s.substring(1), p));
        }
        return flag && isMatch(s.substring(1), p.substring(1));
    }

    public static boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    public static boolean dfs(char[] s, int s1, char[] p, int p1) {
//        int len1 = s.length;
//        int len2 = p.length;
        if (p1 >= p.length) {
            return s1 >= s.length;
        }
        boolean flag = s1 > s.length && ((s[s1] == p[p1]) || p[p1] == '.');
        if (p.length - p1 >= 2 && p[p1 + 1] == '*') {
            return dfs(s, s1, p, p1 + 2) || (flag && dfs(s, s1 + 1, p, p1));
        }
        return flag && dfs(s, s1 + 1, p, p1 + 1);
    }

//    int[][] mem;
//    public boolean isMatchChar(char[] s, int s1, char[] p, int p1) {
//        if(p1 >= p.length) return s1 >= s.length;
//        if(mem[s1][p1] != 0) return mem[s1][p1] > 0;
//        boolean match = s1 < s.length && ((s[s1] == p[p1]) || p[p1] == '.');
//        if(p.length - p1 >= 2 && p[p1 + 1] == '*') {
//            boolean t = isMatchChar(s, s1, p, p1 + 2) || (match && isMatchChar(s, s1 + 1, p, p1));
//            if(t) mem[s1][p1] = 1;
//            else mem[s1][p1] = -1;
//            return t;
//        }
//        boolean t = match && isMatchChar(s, s1 + 1, p, p1 + 1);
//        if(t) mem[s1][p1] = 1;
//        else mem[s1][p1] = -1;
//        return t;
//    }
//
//    public boolean isMatch(String s, String p) {
//        this.mem = new int[s.length() + 1][p.length() + 1];
//        char[] ss = s.toCharArray(), pp = p.toCharArray();
//        return isMatchChar(ss, 0, pp, 0);
//    }
}