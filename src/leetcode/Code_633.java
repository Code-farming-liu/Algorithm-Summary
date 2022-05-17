package leetcode;

/**
 * @ClassName: Code_633
 * @Description: 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 * @Author: Admin
 **/

public class Code_633 {
    public static boolean judgeSquareSum(int c) {
        if (c < 3) {
            return true;
        }
        for (long i = 0; i * i < c; i++) {
            double sqrt = Math.sqrt(c - i * i);
            if (sqrt == (int)sqrt) {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum1(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

        public static void main(String[] args) {
        judgeSquareSum(2);
    }
}