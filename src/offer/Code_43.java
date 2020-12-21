package offer;

/**
 * @ClassName: Test39
 * @Description: 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @Author: Admin
 **/

public class Code_43 {
    //将字符串分为两部分，首先先反转前半部分 之后反转后半部分，最后全部反转。

    /**
     * @param str
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 当然我们也可以用旋转的方式来实现，我们可以
     * 先旋转对应的要左移的字符串，
     * 之后再去旋转剩余字符串
     * 最后旋转整个字符串即可
     * 例如：abcXYZdef 先旋转abc ----> cba
     * 旋转剩余部分 也就是 XYZdef ----> fedZYX
     * 现在变成 cbafedZYX
     * 最后整体旋转 变为 XYZdefabc 完成旋转
     * @return: java.lang.String
     */
    public String LeftRotateString1(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) {
            return "";
        }
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    //将对应字符串截取重新拼接

    /**
     * @param str
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以用一种简单的办法，也就是将对应的要反转的字符串截取出来，之后拼接在最后面即可
     * @return: java.lang.String
     */
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String temp = str.substring(0, n);

        for (int i = n; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        sb.append(temp);
        return sb.toString();
    }

}