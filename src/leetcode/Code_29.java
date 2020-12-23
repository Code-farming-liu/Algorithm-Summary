package leetcode;

/**
 * @ClassName: Test57
 * @Description: 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8
 * 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * @Author: Admin
 **/

public class Code_29 {
    /**
     * @param dividend
     * @param divisor
     * @Author: Admin
     * @Description: 思路描述：
     * 将两个数转换为负数运算（防止正数发生越界等原因），
     * 每次都是使用位的左移来判断当前数的的2倍是不是小于被除数，带有符号的左移，符号位不会进行忽略
     * 用于减少减的次数，然后被除数减去 2倍除数 剩余的继续循环，
     * 直到被除数大于除数结束循环，最后将结果的正负利用异或进行判断。 
     * @return: int
     */
    public int divide(int dividend, int divisor) {
        //判断结果的正负
        // 利用对应的 异或运算
        //相同为 false 不同为 true
        boolean sign = (dividend > 0) ^ (divisor > 0);
        //最终结果
        int result = 0;
        //都将其装换为 负数， 防止发生越界等
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        //因为将数字都转为了负数
        while (dividend <= divisor) {
            //临时结果也就是对应的 临时商
            int temp_result = -1;
            //临时结果也就是对应的 临时除数
            int temp_divisor = divisor;
            //左移 << 相当于 无符号 左移 也就是 * 2
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) {
                    break;
                }
                //确定倍数关系 每次 2倍
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            // 倍数 之后 还剩余的
            dividend -= temp_divisor;
            //保存对应的结果
            result += temp_result;
        }
        //判断结果应该是正数 还是负数
        if (!sign) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = -result;
        }
        return result;
    }
}
