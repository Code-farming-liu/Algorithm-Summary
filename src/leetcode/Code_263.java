package leetcode;

// 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
//
//丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
// 
//
//示例 1：
//
//输入：n = 6
//输出：true
//解释：6 = 2 × 3
//示例 2：
//
//输入：n = 8
//输出：true
//解释：8 = 2 × 2 × 2
//示例 3：
//
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
//示例 4：
//
//输入：n = 1
//输出：true
//解释：1 通常被视为丑数。
//
public class Code_263 {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
