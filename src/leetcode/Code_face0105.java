package leetcode;

/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Code_face0105 {
    public boolean oneEditAway(String first, String second) {
        int f = first.length();
        int s = second.length();
        if (Math.abs(f - s) > 1) {
            return false;
        }
        if (f - s > 0) {
            String temp = first;
            first = second;
            second = temp;
            int t = f;
            f = s;
            s = t;
        }

        int i = 0, j = 0, count = 0;
        while (i < f && j < s && count <= 1) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                if (f == s) {
                    i++;
                    j++;
                    count++;
                } else {
                    j++;
                    count++;
                }
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String s1 = "teacher";
        String s2 = "beacher";
        System.out.println(new Code_face0105().oneEditAway(s1, s2));
    }
}
