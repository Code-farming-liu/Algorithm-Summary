/**
 * @ClassName: Test03
 * @Description: 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author: Admin
 * @Date 2020/9/2 14:01
 **/

public class Test03 {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}