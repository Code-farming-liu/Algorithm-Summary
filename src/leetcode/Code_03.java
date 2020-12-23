package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * @ClassName: Test50
 * @Description: 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author: Admin
 **/

public class Code_03 {

    //思路一

    /**
     * @param str
     * @Author: Admin
     * @Description: 思路一：
     * 我们使用两个指针表示字符串中的某个字串的（左右边界）。
     * 在每一步操作中我们将左指针向右移动一格，表示我们开始枚举下一个字符的起始位置，
     * 之后不断移动右指针，直到碰到重复的，记下此时的最长子串。
     * 使用HashSet 集合辅助遍历
     * @return: int
     */
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

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路二：
     * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，
     * value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 我们定义不重复子串的开始位置为 start，结束位置为 end
     * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，
     * 此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end]
     * 区间内不存在重复字符
     * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
     * @return: int
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                temp = Math.max(map.get(s.charAt(i)), temp);
            }
            max = Math.max(i - temp + 1, max);
            map.put(s.charAt(i), i + 1);
        }
        return max;
    }
}
