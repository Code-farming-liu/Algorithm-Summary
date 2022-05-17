package leetcode;

/**
 * @ClassName: Code_367
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/10 20:26
 **/

public class Code_367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        if (num == 1) {
            return true;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}