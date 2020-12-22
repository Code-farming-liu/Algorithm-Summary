package offer;

/**
 * @ClassName: Test43
 * @Description: 把字符串转换成整数
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 * 1a33
 * 输出
 * 复制
 * 2147483647
 * 0
 * @Author: Admin
 **/

public class Code_49 {
    /**
     * @param str
     * @Author: Admin
     * @Description: 思路描述：
     *
     * 我们可以简单的建对应的字符串 转换成char数组，之后根据符号还是数字去判断当前应该是什么，
     * 判断是否越界 即可
     * @return: int
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long res = 0;
        boolean is = str.charAt(0) == '-';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                continue;
            }
            if (c < '0' || c > '9') {
                return 0;
            }
            res = res * 10 + (c - '0');
        }
        if (is == true && (-res) < Integer.MIN_VALUE) {
            return 0;
        }
        if (is == true && res > Integer.MAX_VALUE) {
            return 0;
        }
        return is ? (int) -res : (int) res;
    }
}