package leetcode;

import java.util.*;

/**
 * @ClassName: Code_692
 * @Description: 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *  
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * @Author: Admin
 * @Date 2021/5/20 22:57
 **/

public class Code_692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Object[]> q = new PriorityQueue<>(k, (a, b) -> {
            // 如果词频不同，根据词频升序
            int c1 = (Integer) a[0], c2 = (Integer) b[0];
            if (c1 != c2) {
                return c1 - c2;
            }
            // 如果词频相同，根据字典序倒序
            String s1 = (String) a[1], s2 = (String) b[1];
            return s2.compareTo(s1);
        });
        for (String s : map.keySet()) {
            int cnt = map.get(s);
            if (q.size() < k) { // 不足 k 个，直接入堆
                q.add(new Object[]{cnt, s});
            } else {
                Object[] peek = q.peek();
                if (cnt > (Integer) peek[0]) { // 词频比堆顶元素大，弹出堆顶元素，入堆
                    q.poll();
                    q.add(new Object[]{cnt, s});
                } else if (cnt == (Integer) peek[0]) { // 词频与堆顶元素相同
                    String top = (String) peek[1];
                    if (s.compareTo(top) < 0) { // 且字典序大小比堆顶元素小，弹出堆顶元素，入堆
                        q.poll();
                        q.add(new Object[]{cnt, s});
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            res.add((String) q.poll()[1]);
        }
        Collections.reverse(res);
        return res;
    }
}