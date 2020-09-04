/**
 * @ClassName: Test31
 * @Description: 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @Author: Admin
 **/

public class Test31 {
    public int FirstNotRepeatingChar(String str) {
        int[] nums = new int[58];
        for(int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - 'A']++;
        }
        for(int i = 0; i < str.length(); i++) {
            if(nums[str.charAt(i) - 'A'] == 1) {
                return i;
            }
        }
        return -1;
    }
}