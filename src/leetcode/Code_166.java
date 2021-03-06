package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test86
 * Description: 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * <p>
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * <p>
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * <p>
 * @Author: Admin
 **/

public class Code_166 {
    /**
     * @param numerator
     * @param denominator
     * @Author: Admin
     * @Description: 思路分析：
     *
     * 需要用一个哈希表记录余数出现在小数部分的位置，
     * 当你发现已经出现的余数，就可以将重复出现的小数部分用括号括起来。
     *
     * 再出发过程中余数可能为 0，意味着不会出现循环小数，立刻停止程序。
     * @return: java.lang.String
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        //判断负数
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));//分子
        long divisor = Math.abs(Long.valueOf(denominator));//分母
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
} 
