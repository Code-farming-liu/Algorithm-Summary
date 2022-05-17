package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 字符串子序列
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/8 21:45
 **/

public class 字符串子序列 {
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1 ,res + String.valueOf(str[i]));
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test.toCharArray(), 0, "");
    }
}