package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_205
 * @Description: 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * @Author: Admin
 **/

public class Code_205 {

    public static boolean isIsomorphic(String s, String t) {
        int sm[] = new int[128];
        int tm[] = new int[128];
        char sc[] = s.toCharArray();
        char tc[] = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sm[sc[i]] != tm[tc[i]]) {
                return false;
            }
            sm[sc[i]] = tm[tc[i]] = i + 1;
        }
        return true;
    }


    public static void main(String[] args) {
        isIsomorphic("egg", "add");
    }
}