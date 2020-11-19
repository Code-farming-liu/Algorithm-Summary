import java.util.*;

/**
 * @ClassName: Test80
 * Description: 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>

 * @Author: Admin
 **/

public class Test80 {
    //    广度优先算法 也就是从第一个截取字符串 ，然后对应的变换起始索引
    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()]; //判断此索引是否被访问过
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();//用完直接出队列
            if (visited[start] == 0) {//判断起始索引是否被访问过
                for (int end = start + 1; end <= s.length(); end++) { //每次变换起始索引
                    if (wordDictSet.contains(s.substring(start, end))) { //对应的截取，判断是否存在
                        queue.add(end); //存在之后直接使用 这个下标的下一个为起始索引索引
                        if (end == s.length()) { //如果 最后一个与长度相等 说明找到了
                            return true;
                        }
                    }
                }
                visited[start] = 1;//将访问过得其实下标标记为 1
            }
        }
        return false;
    }
    //    //动态规划 几乎和上面同样的思路
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; //判断是否包含
        dp[0] = true;
        //其中 i 是当前字符串从头开始的子字符串（s'）
        //′
        // ）的长度， j 是当前子字符串（s'）
        //′
        // ）的拆分位置，拆分成 s'(0,j)
        //′
        // (0,j) 和 s'(j+1,i)
        //′
        // (j+1,i) 。
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) { //
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {//
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}