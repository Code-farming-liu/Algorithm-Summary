package leetcode;
// 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
//
//你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
//
//请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
//
//子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
//
//
//
//示例 1：
//
//输入：text = "abdcdbc", pattern = "ac"
//输出：4
//解释：
//如果我们在 text[1] 和 text[2] 之间添加 pattern[0] = 'a' ，那么我们得到 "abadcdbc" 。那么 "ac" 作为子序列出现 4 次。
//其他得到 4 个 "ac" 子序列的方案还有 "aabdcdbc" 和 "abdacdbc" 。
//但是，"abdcadbc" ，"abdccdbc" 和 "abdcdbcc" 这些字符串虽然是可行的插入方案，但是只出现了 3 次 "ac" 子序列，所以不是最优解。
//可以证明插入一个字符后，无法得到超过 4 个 "ac" 子序列。
//示例 2：
//
//输入：text = "aabb", pattern = "ab"
//输出：6
//解释：
//可以得到 6 个 "ab" 子序列的部分方案为 "aaabb" ，"aaabb" 和 "aabbb" 。
//
//
//提示：
//
//1 <= text.length <= 105
//pattern.length == 2
//text 和 pattern 都只包含小写英文字母。
public class Code_6021 {
    public long maximumSubsequenceCount(String text, String pattern) {
        long count = 0, count1 = 0, count2 = 0;
        for (char c : text.toCharArray()) {
            count += c == pattern.charAt(1) ? count1 : 0;
            count2 += c == pattern.charAt(1) ? 1 : 0;
            count1 += c == pattern.charAt(0) ? 1 : 0;
        }
        return count + Math.max(count1, count2);
    }
}
