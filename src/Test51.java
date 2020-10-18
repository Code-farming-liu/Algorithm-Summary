/**
 * @ClassName: Test51
 * @Description: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @Author: Admin
 **/

public class Test51 {
    //中心扩散法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    //暴力破解
//    public static String longestPalindrome(String s) {
//        String res = "";
//        int resLen = 0;
//        String temp = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                temp = s.substring(i, j);
//                int len = temp.length();
//                if (is(temp)) {
//                    if(resLen < len) {
//                        resLen = len;
//                        res = temp;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    public static boolean is(String str) {
//        int length = str.length();
//        int start = 0, end = length - 1;
//        while (start < end) {
//            if (str.charAt(start) != str.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }
    //使用动态规划
//    public static String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        int begin = 0;
//        //dp[i][j] 表示s[i, j] 是否是回文子串
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//        //将对角线的值 设置为 true
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                //判断当前的字符串的 首字符 和 尾字符是否相等
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    //如果当前的字符串长度 小于 4
//                    // 那么就可以直接根据首尾字符去判断当前的字符是否是回文串
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        //如果不是 则判断中间的子串是不是回文子串
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//                //判断最长的回文子串
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//
//        return s.substring(begin, begin + maxLen);
//    }
    //中心扩散法
//    public static String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        String res = s.substring(0, 1);
//        // 中心位置枚举到 len - 2 即可
//        for (int i = 0; i < len - 1; i++) {
//            String oddStr = centerSpread(s, i, i);
//            String evenStr = centerSpread(s, i, i + 1);
//            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
//            if (maxLenStr.length() > maxLen) {
//                maxLen = maxLenStr.length();
//                res = maxLenStr;
//            }
//        }
//        return res;
//    }
//
//    private static String centerSpread(String s, int left, int right) {
//        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
//        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
//        int len = s.length();
//        int i = left;
//        int j = right;
//        while (i >= 0 && j < len) {
//            if (s.charAt(i) == s.charAt(j)) {
//                i--;
//                j++;
//            } else {
//                break;
//            }
//        }
//        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
//        return s.substring(i + 1, j);
//    }
}