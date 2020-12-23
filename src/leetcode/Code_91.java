package leetcode;

/**
 * @ClassName: Test70
 * @Description: 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * @Author: Admin
 **/

public class Code_91 {
    public static int numDecodings2(String s) {
        int len = s.length();
        int end = 1;
        int cur = 0;
        if (s.charAt(len - 1) != '0') {
            cur = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                //end 前移
                end = cur;
                cur = 0;
                continue;
            }
            int ans1 = cur;
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = end;
            }
            //end 前移
            end = cur;
            cur = ans1 + ans2;
        }
        return cur;
    }

    //动态规划

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 同样的，递归就是压栈压栈压栈，出栈出栈出栈的过程，我们可以利用动态规划的思想，省略压栈的过程，
     * 直接从 bottom 到 top。
     *
     * 用一个 dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的
     * 解码方式。
     *
     * 这样和递归完全一样的递推式。
     *
     * 如果 s [ i ] 和 s [ i + 1 ] 组成的数字小于等于 26，那么
     *
     * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
     * @return: int
     */
    public static int numDecodings1(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1; //将递归法的结束条件初始化为 1
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;

        }
        return dp[0];
    }

    //解法二：递归

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 很容易想到递归去解决，将大问题化作小问题。
     * <p>
     * 比如 232232323232。
     * <p>
     * 对于第一个字母我们有两种划分方式。
     * <p>
     * 2|32232323232 和 23|2232323232
     * <p>
     * 所以，如果我们分别知道了上边划分的右半部分 32232323232 的解码方式是 ans1 种，
     * 2232323232 的解码方式是 ans2 种，那么整体 232232323232 的解码方式就是 ans1 + ans2 种。
     * 可能一下子，有些反应不过来，可以看一下下边的类比。
     * <p>
     * 假如从深圳到北京可以经过武汉和上海两条路，而从武汉到北京有 8 条路，从上海到北京有 6 条路。
     * 那么从深圳到北京就有 8 + 6 = 14 条路。
     * @return: int
     */
    public static int numDecodings(String s) {
        return getAns(s, 0);
    }

    //
    private static int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}