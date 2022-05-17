package leetcode.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *  
 *
 * 示例 1：
 *
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "    .1  "
 * 输出：true
 *
 */
public class Code_20 {
    public boolean isNumber(String s) {
        // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        if (s.length() == 0) {
            return false;
        }
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false, isDot = false, isE = false;
        // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 判断当前字符是否为 0~9 的数位
            if (chars[i] >= '0' && chars[i] <= '9') {
                isNum = true;
                // 遇到小数点
            } else if (chars[i] == '.') {
                // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                if (isDot || isE) {
                    return false;
                }
                // 标记已经遇到小数点
                isDot = true;
                // 遇到‘e’或'E'
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                if (!isNum || isE) {
                    return false;
                }
                // 标记已经遇到‘e’或'E'
                isE = true;
                // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
                isNum = false;
            } else if (chars[i] == '-' || chars[i] == '+') {
                // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') {
                    return false;
                }
            } else {
                // 其它情况均为不合法字符
                return false;
            }
        }
        return isNum;
    }
}
