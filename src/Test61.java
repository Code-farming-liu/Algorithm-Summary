import java.util.*;

/**
 * @ClassName: Test61
 * @Description: 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @Author: Admin
 * @Date 2020/11/12 21:34
 **/

public class Test61 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        //如果为数组为null 返回一个空的集合
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> res = new HashMap<>();
        for (String s : strs) {
            //将其转换为字符数组
            char[] ca = s.toCharArray();
            //将其进行排序
            Arrays.sort(ca);
            //将对应排序后的 字符串作为 key
            String key = String.valueOf(ca);
            //如果map集合中包含，证明是字母异位数组 因此我们将他们加入到对应的集合中
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList());
            }
            List list = res.get(key);
            list.add(s);
        }
        //将对应的 结果封装在一个大的集合之中
        return new ArrayList(res.values());
    }
}