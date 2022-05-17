package leetcode;

/**
 * @ClassName: Code_342
 * @Description: 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 * @Author: Admin
 **/

public class Code_342 {
    public boolean isPowerOfFour(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}