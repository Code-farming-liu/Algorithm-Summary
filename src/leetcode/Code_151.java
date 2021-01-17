package leetcode;

/**
 * @ClassName: Code_151
 * @Description: 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 * <p>
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * <p>
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * @Author: Admin
 **/

public class Code_151 {
    /**
     * @param s
     * @Author: Admin
     * @Description: 首先我们先去除原字符串中的空格，
     * 之后反转整个句子 ，然后在反转单词  根据空格 判断单词的起始位置，
     * 最后一个单词独自进行翻转，我们在对结果进行空格的处理即可
     * @return: java.lang.String
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // 去除前面的空格
        String s1 = s.trim();
        char[] chars = s1.toCharArray();
        // 反转整个句子
        reverse(chars, 0, chars.length - 1);
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int last = i;
                // 反转每个单词
                reverse(chars, start + 1, last - 1);
                start = last;
            }
        }
        // 最后一个单词独自反转
        reverse(chars, start + 1, chars.length - 1);
        StringBuilder res = new StringBuilder();
        res.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            res.append(chars[i]);
        }
        return res.toString();
    }

    // 反转单词
    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}