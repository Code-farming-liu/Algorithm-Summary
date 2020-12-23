package leetcode;

import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: Test77
 * Description: 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * @Author: Admin
 **/

public class Code_127 {
    /**
     * @param beginWord
     * @param endWord
     * @param wordList
     * @Author: Admin
     * @Description: 思路描述：
     * 使用双端队列，然后将字符串转换为char数组，一个临时变量保存当前的字符，
     * 将字符转换为单词判断字典中是不是包含该单词，如果包含该单词并且最后一个也是该单词证明找到了，
     * 否则将单词加入到next；
     * 将临时变量赋值给char数组，
     * 如果开始的单词为null 则直接返回0，
     * 否则循环此过程
     * @return: int
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> start = new HashSet<>(beginWord.length());
        start.add(beginWord);
        HashSet<String> end = new HashSet<>(endWord.length());
        end.add(endWord);
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        //因为最少有两层高度 开始 结束
        return deBfs(start, end, words, 2);
    }

    public int deBfs(HashSet<String> start, HashSet<String> end, HashSet<String> words, int depth) {
        if (start.size() > end.size()) {
            //双端队列的意义之处，这样能保证每次的分支最小。
            // 例如：从前找有10个分支 从尾找只有3个分支 那肯定找3个分支要快 （且扩散的分支要少）。
            // 这也是双端搜索的特点
            return deBfs(end, start, words, depth);
        }
        //将最开始的出队列
        words.removeAll(start);
        //用于保存下一个单词
        HashSet<String> next = new HashSet<>();
        //遍历开始的单词
        for (String str : start) {
            //将str转换为 char数组
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                //临时存储字符
                char temp = chars[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    //将字符保存在char数组中
                    chars[i] = j;
                    //将chars数组转换为字符串
                    String word = new String(chars);
                    //如果字典中包含这个单词
                    if (words.contains(word)) {
                        //最后一个也是这个这个单词 那么证明找到了
                        if (end.contains(word)) {
                            return depth;
                        }
                        //否则没有找到将单词加入到下一个
                        next.add(word);
                    }
                }
                chars[i] = temp;
            }
        }
        if (start.isEmpty()) {
            return 0;
        }
        return deBfs(next, end, words, depth + 1);
    }
}