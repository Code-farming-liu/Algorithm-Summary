package leetcode;

/**
 * @ClassName: Code_09
 * @Description: 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 * @Author: Admin
 **/

public class Code_09 {
    // 反转加以比较
    public boolean isPalindrome(int x) {
        int temp = x;
        if (x == 0) {
            return true;
        }
        int res = 0;
        int m;
        while (temp > 0) {
            m = temp % 10;
            res = res * 10 + m;
            temp /= 10;
        }
        return x == res;
    }
}