package leetcode;

/**
 * @ClassName: Code_07
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/23 10:33
 **/

public class Code_07 {
    public static int reverse(int x) {
        String str = x + "";
        boolean flag = true;
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            flag = false;
        }
        StringBuilder sb = new StringBuilder();
//        sb.append(flag ? "" : "-");
        int index = str.length() - 1;
        char[] chars = str.toCharArray();
        while (index >= 0 && chars[index] == '0') {
            index--;
        }
        while (index >= 0 && chars[index] != '-') {
            sb.append(chars[index]);
            index--;
        }
        int res = Integer.parseInt(sb.toString());
        return flag ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
}