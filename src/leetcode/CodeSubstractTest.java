package leetcode;

/**
 * @ClassName: CodeSubstractTest
 * @Description: 两个非常大的数字相加
 * @Author: Admin
 * @Date 2021/4/22 14:43
 **/

public class CodeSubstractTest {
    public static String bigNumberSub(String str1, String str2) {
        char[] chars1 = new StringBuilder(str1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(str2).reverse().toString().toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        int len = len1 > len2 ? len1 : len2;
        int[] res = new int[len];
        char sign = '+';
        if (len1 < len2) {
            sign = '-';
        } else if (len1 == len2) {
            int i = len1 - 1;
            while (i > 0 && chars1[i] == chars2[i]) {
                i--;
            }
            if (chars1[i] < chars2[i]) {
                sign = '-';
            }
        }
        for (int i = 0; i < len; i++) {
            int val1 = i < len1 ? (chars1[i] - '0') : 0;
            int val2 = i < len2 ? (chars2[i] - '0') : 0;
            if (sign == '+') {
                res[i] = val1 - val2;
            } else {
                res[i] = val2 - val1;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            if (res[i] < 0) {
                res[i + 1] -= 1;
                res[i] += 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (sign == '-') {
            sb.append('-');
        }

        boolean flag = true;
        for (int i = len - 1; i >= 0; i--) {
            if (res[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(res[i]);
        }

        if ("".equals(sb.toString())) {
            sb.append("0");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


    public static void main(String[] args) {
        bigNumberSub("124", "1231");
    }
}