package huawei;

import java.util.Scanner;

/**
 * warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 描述
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 * <p>
 * 示例1
 * 输入：
 * abc
 * 复制
 * 输出：
 * abc00000
 */
public class Code_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        String str = "abc";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i += 8) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 8 && j < chars.length; j++) {
                sb.append(chars[j]);
            }
            if (sb.length() != 8) {
                for (int j = sb.length(); j < 8; j++) {
                    sb.append("0");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
