package leetcode;

/**
 * @ClassName: Code_08
 * @Description: 字符串转整数
 * @Author: Admin
 **/

public class Code_08 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int index = 0;
        boolean flag = false;
        while (index < n && chars[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        if (chars[index] == '-') {
            flag = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }
        int res = 0;
        while (index < n && Character.isDigit(chars[index])) {
            int temp = chars[index] - '0';
            if (res > (Integer.MAX_VALUE - temp) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + temp;
            index++;
        }
        return flag ? -res : res;
    }


    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }

}