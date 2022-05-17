package leetcode;

/**
 * @ClassName: Code_07
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/23 10:33
 **/

public class Code_07 {
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean flag = x > 0;
        String str = x + "";
        int res = 0;
        int index = str.length() - 1;
        char[] chars = str.toCharArray();
        // 去除后置0
        while (index >= 0 && chars[index] == '0') {
            index--;
        }
        // 倒序
        while (index >= 0 && chars[index] != '-') {
            // 越界处理  res * 10 + chars[index] - '0' > Integer.MAX_VALUE 改为除法
            if (res > (Integer.MAX_VALUE - (chars[index] - '0')) / 10) {
                return 0;
            }
            res = res * 10 + chars[index] - '0';
            index--;
        }
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
}