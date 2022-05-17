package leetcode;

/**
 * @ClassName: Code_43
 * @Description: 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @Author: Admin
 **/

public class Code_43 {
    public static String multiply1(String num1, String num2) {
        String sum = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = help(num1, num2.charAt(i) - '0' + "");
            int j = num2.length() - (i + 1);
            while (j > 0) {
                temp += "0";
                j--;
            }
            sum = add(sum, temp);
        }
        return sum.charAt(0) == '0' ? "0" : sum;
    }

    public static String help (String str1, String str2) {
        char[] chars1 = new StringBuilder(str1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(str2).reverse().toString().toCharArray();
        int p1 = 0, p2 = 0, temp = 0;
        StringBuilder res = new StringBuilder();
        int val2 = p2 < chars2.length ? chars2[p2] - '0' : 0;
        while (p1 < chars1.length || temp != 0) {
            int val1 = p1 < chars1.length ? chars1[p1++] - '0' : 0;
            int sum = val1 * val2 + temp;
            temp = sum / 10;
            res.append(sum % 10);
        }
        return res.reverse().toString();
    }


    public static String add(String str1, String str2) {
        char[] chars1 = new StringBuilder(str1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(str2).reverse().toString().toCharArray();
        int p1 = 0, p2 = 0, temp = 0;
        StringBuilder res = new StringBuilder();
        while (p1 < chars1.length || p2 < chars2.length || temp != 0) {
            int val1 = p1 < chars1.length ? chars1[p1++] - '0' : 0;
            int val2 = p2 < chars2.length ? chars2[p2++] - '0' : 0;
            int sum = val1 + val2 + temp;
            temp = sum / 10;
            res.append(sum % 10);
        }
        return res.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("12", "18"));
    }

}