package leetcode.offer;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 < nums.length <= 100
 * 说明:
 */
public class Code_45 {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : str) {
            res.append(s);
        }
        return res.toString();
    }
}
