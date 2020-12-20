package offer;

/**
 * @ClassName: Test03
 * @Description: 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author: Admin
 **/

public class Code_02 {
    /**
     * @param str
     * @return java.lang.String
     * @Author Admin
     * @Description： 思路描述
     * 我们可以直接使用一个新的StringBuilde拼接，
     * 将原来的字符串通过 toCharArray()，转换为char数组，之后遍历char数组，
     * 如果有空格则替换为%20，添加到新的StringBuilder，
     * 否则直接添加到新的StringBuilder
     * 最后返回字符串即可。
     **/
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
