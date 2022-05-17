package leetcode;

/**
 * @ClassName: Code_1221
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/7 11:00
 **/

public class Code_1221 {
    public static void main(String[] args) {
        String str = "RLRRLLRLRL";
        balancedStringSplit(str);
    }
    public static int balancedStringSplit(String s) {
        int res = 0, count = 0;
        for (char c : s.toCharArray()) {
            res = c == 'L' ? res++ : res--;
            if (res == 0) {
                count++;
            }
        }
        return count;
    }
}