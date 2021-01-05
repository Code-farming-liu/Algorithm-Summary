package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_830
 * @Description: 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 * <p>
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 * <p>
 * 输入：s = "aba"
 * 输出：[]
 * @Author: Admin
 **/

public class Code_830 {


    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述
     * 暴力保存一个分组的开始下标，和结束下表，如果他们的差值大于等于 3 加入到集合中
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public static List<List<Integer>> largeGroupPositions1(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int length = s.length();
        if (s == "" || length == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            if (chars[i] == chars[i - 1]) {
                int temp = i - 1;
                while (i < length && chars[temp] == chars[i]) {
                    i++;
                }
                if (i - temp >= 3) {
                    list.add(temp);
                    list.add(i - 1);
                }
            }
            if (list.size() != 0) {
                res.add(list);
            }
        }
        return res;
    }

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 同样思路只不过是使用一个计数器变量，统计大于等于3加入集合中。
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        int length = s.length();
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < length; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == length - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (count >= 3) {
                    list.add(i - count + 1);
                    list.add(i);
                    res.add(list);
                }
                // 计数器重置
                count = 1;
            } else {
                count++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        largeGroupPositions("abbxxxxzzy");
    }
}