import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Test50
 * @Description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @Author: Admin
 **/

public class Test50 {

    //思路一
    public static int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int n = str.length();
        int right = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(str.charAt(i - 1));
            }
            while (right + 1 < n && !set.contains(str.charAt(right + 1))) {
                set.add(str.charAt(right + 1));
                right++;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }

    //思路二：

//    public int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> map = new HashMap();
//        int count = 0;
//        int max = 0;
//        int temp = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                temp = Math.max(map.get(s.charAt(i)), temp);
//            }
//            max = Math.max(i - temp + 1, max);
//            map.put(s.charAt(i), i + 1);
//        }
//        return max;
//    }
}