/**
 * @ClassName: Test39
 * @Description: 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @Author: Admin
 **/

public class Test39 {
    //将字符串分为两部分，首先先反转前半部分 之后反转后半部分，最后全部反转。
//    public String LeftRotateString(String str, int n) {
//        char[] chars = str.toCharArray();
//        if (chars.length < n) {
//            return "";
//        }
//        reverse(chars, 0, n - 1);
//        reverse(chars, n, chars.length - 1);
//        reverse(chars, 0, chars.length - 1);
//
//        return new String(chars);
//    }
//
//    public void reverse(char[] chars, int start, int end) {
//        while (start < end) {
//            char temp = chars[start];
//            chars[start] = chars[end];
//            chars[end] = temp;
//            start++;
//            end--;
//        }
//    }
        //将对应字符串截取重新拼接
        public String LeftRotateString(String str,int n) {
            if(str == null || str.length() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            String temp = str.substring(0, n );

            for(int i = n; i < str.length(); i++) {
                sb.append(str.charAt(i));
            }
            sb.append(temp);
            return sb.toString();
        }

}