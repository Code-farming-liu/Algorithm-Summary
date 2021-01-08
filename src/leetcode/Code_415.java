package leetcode;

/**
 * @ClassName: Code_415
 * @Description: 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * @Author: Admin
 **/

public class Code_415 {
    /**
     * @param num1
     * @param num2
     * @Author: Admin
     * @Description: 思路描述：
     * 我们将每个字符串中字符取出来，然后我们将其相加，处理进位即可。
     * @return: java.lang.String
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        int p1 = length1 - 1;
        int p2 = length2 - 1;
        int temp = 0;
        while (p1 >= 0 || p2 >= 0 || temp != 0) {
            int value1 = p1 >= 0 ? (num1.charAt(p1--) - '0') : 0;
            int value2 = p2 >= 0 ? (num2.charAt(p2--) - '0') : 0;
            int sum = value1 + value2 + temp;
            temp = sum / 10;
            res.append(sum % 10);
        }
        return res.reverse().toString();
    }
}