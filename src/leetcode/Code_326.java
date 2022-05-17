package leetcode;

/**
 * @ClassName: Code_326
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/23 15:11
 **/

public class Code_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}