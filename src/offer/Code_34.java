package offer;

/**
 * @ClassName: Test31
 * @Description: 第一个只出现一次的字符位置
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @Author: Admin
 **/

public class Code_34 {
    /**
     * @param str
     * @Author: Admin
     * @Description: 思路描述:
     * 我们根据题目可以提取出 全部由字母组成 因此我们可以使用一个足够大的数组，
     * 数组的下标为 对应的字母 与 A 相减，如果相同的话直接加一，之后我们去判断对应的值为1的下标，
     * 然后进行返回。
     * @return: int
     */
    public int FirstNotRepeatingChar(String str) {
        int[] nums = new int[58];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i) - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }
}