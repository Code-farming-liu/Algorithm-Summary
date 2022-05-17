package leetcode;

/**
 * @ClassName: Code_5875
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/19 10:31
 **/

public class Code_5875 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("X++") || operations[i].equals("++X")) {
                res++;
            } else {
                res--;
            }
        }
        return res;
    }
}