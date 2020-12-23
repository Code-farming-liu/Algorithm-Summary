package leetcode;


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

public class Code_05 {
    //中心扩散法

    /**
     * @param s
     * @Author: Admin
     * @Description: 方法三： 中心扩散法
     * 中心扩散法：
     * 暴力法采用双指针两边夹，验证是否是回文子串。
     *
     * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，
     * 从“中心位置”尝试尽可能扩散出去，得到一个回文串。
     *
     * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，
     * 往两边扩散，看最多能扩散多远。
     *
     * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
     *
     * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
     * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，
     * 例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
     *
     * 重点
     * 我们可以设计一个方法，兼容以上两种情况：
     *
     * 1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
     *
     * 2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
     * @return: java.lang.String
     */
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

    /**
     * @param s
     * @Author: Admin
     * @Description: 暴力破解：
     * 首先定义一个方法，利用双指针方法判断当前的字符串是不是一个回文串，
     * 之后开始暴力截取所有子串并判断即可
     * 根据回文子串的定义，枚举所有长度大于等于 22 的子串，依次判断它们是否是回文；
     * 在具体实现时，可以只针对大于“当前得到的最长回文子串长度”的子串进行“回文验证”；
     * 在记录最长回文子串的时候，可以只记录“当前子串的起始位置”和“子串长度”，不必做截取。
     * 这一步我们放在后面的方法中实现。
     * @return: java.lang.String
     */
    public static String longestPalindrome3(String s) {
        String res = "";
        int resLen = 0;
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                temp = s.substring(i, j);
                int len = temp.length();
                if (is(temp)) {
                    if (resLen < len) {
                        resLen = len;
                        res = temp;
                    }
                }
            }
        }
        return res;
    }

    //判断是否是回文串
    public static boolean is(String str) {
        int length = str.length();
        int start = 0, end = length - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
    }

    //使用动态规划

    /**
     * @param s
     * @Author: Admin
     * @Description: 方法二:动态规划
     * 这道题比较烦人的是判断回文子串。因此需要一种能够快速判断原字符串的所有子串是否是回文子串的方法，
     * 于是想到了「动态规划」。
     *
     * 「动态规划」的一个关键的步骤是想清楚「状态如何转移」。
     * 事实上，「回文」天然具有「状态转移」性质。
     *
     * 一个回文去掉两头以后，剩下的部分依然是回文（这里暂不讨论边界情况）；
     * 依然从回文串的定义展开讨论：
     *
     * 如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
     * 如果一个字符串的头尾两个字符相等，才有必要继续判断下去。
     * 如果里面的子串是回文，整体就是回文串；
     * 如果里面的子串不是回文串，整体就不是回文串。
     * 第一步： 定义状态
     * dp[i][j] 表示子串 s[i..j] 是否为回文子串，这里子串 s[i..j] 定义为左闭右闭区间，
     * 可以取到 s[i] 和 s[j]。
     *
     * 第二步：思考状态转移方程
     * 在这一步分类讨论（根据头尾字符是否相等），根据上面的分析得到：
     *
     * dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
     *
     * 说明：
     *
     * 「动态规划」事实上是在填一张二维表格，由于构成子串，因此 i 和 j 的关系是 i <= j ，
     * 因此，只需要填这张表格对角线以上的部分。
     *
     * 看到 dp[i + 1][j - 1] 就得考虑边界情况。
     *
     * 边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，
     * 即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     *
     * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2
     * 或者等于 3 的时候，其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
     *
     *   如果子串 s[i + 1..j - 1] 只有 1 个字符，即去掉两头，剩下中间部分只有 1 个字符，显然是回文；
     *   如果子串 s[i + 1..j - 1] 为空串，那么子串 s[i, j] 一定是回文子串。
     * 因此，在 s[i] == s[j] 成立和 j - i < 3 的前提下，
     * 直接可以下结论，dp[i][j] = true，否则才执行状态转移。
     * 第 3 步：考虑初始化
     * 初始化的时候，单个字符一定是回文串，因此把对角线先初始化为 true，即 dp[i][i] = true 。
     * 事实上，初始化的部分都可以省去。
     * 因为只有一个字符的时候一定是回文，dp[i][i] 根本不会被其它状态值所参考。
     *
     * 第 4 步：考虑输出
     * 只要一得到 dp[i][j] = true，就记录子串的长度和起始位置，没有必要截取，
     * 这是因为截取字符串也要消耗性能，记录此时的回文子串的「起始位置」和「回文长度」即可。
     * @return: java.lang.String
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        //dp[i][j] 表示s[i, j] 是否是回文子串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        //将对角线的值 设置为 true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //判断当前的字符串的 首字符 和 尾字符是否相等
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //如果当前的字符串长度 小于 4
                    // 那么就可以直接根据首尾字符去判断当前的字符是否是回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //如果不是 则判断中间的子串是不是回文子串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //判断最长的回文子串
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    //中心扩散法
    /**
     * @Author: Admin
     * @Description: 方法三： 中心扩散法
     * 中心扩散法：
     * 暴力法采用双指针两边夹，验证是否是回文子串。
     *
     * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，
     * 从“中心位置”尝试尽可能扩散出去，得到一个回文串。
     *
     * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，
     * 往两边扩散，看最多能扩散多远。
     *
     * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
     *
     * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
     * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，
     * 例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
     *
     * 重点
     * 我们可以设计一个方法，兼容以上两种情况：
     *
     * 1、如果传入重合的索引编码，进行中心扩散，此时得到的回文子串的长度是奇数；
     *
     * 2、如果传入相邻的索引编码，进行中心扩散，此时得到的回文子串的长度是偶数。
     * @param s
     * @return: java.lang.String
     */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }
}
