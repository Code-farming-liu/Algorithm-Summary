package algorithmFourth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: Code_1239
 * @Description: 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * @Author: Admin
 **/

public class Code_1239 {
    //    static Map<Integer, Integer> map = new HashMap<>();
//    int get(int cur) {
//        if (map.containsKey(cur)) {
//            return map.get(cur);
//        }
//        int ans = 0;
//        for (int i = cur; i > 0; i -= lowbit(i)) {
//            ans++;
//        }
//        map.put(cur, ans);
//        return ans;
//    }
//    int lowbit(int x) {
//        return x & -x;
//    }
//
//    int n;
//    int ans = Integer.MIN_VALUE;
//    int[] hash;
//    public int maxLength(List<String> _ws) {
//        n = _ws.size();
//        HashSet<Integer> set = new HashSet<>();
//        for (String s : _ws) {
//            int val = 0;
//            for (char c : s.toCharArray()) {
//                int t = (int)(c - 'a');
//                if (((val >> t) & 1) != 0) {
//                    val = -1;
//                    break;
//                }
//                val |= (1 << t);
//            }
//            if (val != -1) set.add(val);
//        }
//
//        n = set.size();
//        if (n == 0) {
//            return 0;
//        }
//        hash = new int[n];
//
//        int idx = 0;
//        int total = 0;
//        for (Integer i : set) {
//            hash[idx++] = i;
//            total |= i;
//        }
//        dfs(0, 0, total);
//        return ans;
//    }
//    void dfs(int u, int cur, int total) {
//        if (get(cur | total) <= ans) {
//            return;
//        }
//        if (u == n) {
//            ans = Math.max(ans, get(cur));
//            return;
//        }
//        // 在原有基础上，选择该数字（如果可以）
//        if ((hash[u] & cur) == 0) {
//            dfs(u + 1, hash[u] | cur, total - (total & hash[u]));
//        }
//        // 不选择该数字
//        dfs(u + 1, cur, total);
//    }
    int res = 0;

    public int maxLength(List<String> strs) {
        dfs(strs, new StringBuilder(), 0);
        return res;
    }

    public void dfs(List<String> strs, StringBuilder stringBuilder, int start) {
        char[] chars = stringBuilder.toString().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) {
                return;
            } else {
                set.add(c);
            }
        }
        res = Math.max(res, stringBuilder.length());
        for (int i = start; i < strs.size(); i++) {
            stringBuilder.append(strs.get(i));
            dfs(strs, stringBuilder, i + 1);
//            stringBuilder.delete(stringBuilder.length() - strs.get(i).length(), stringBuilder.length());
        }
    }

    public static void main(String[] args) {
        String[] strs = {"un", "iq", "ue"};
        new Code_1239().maxLength(Arrays.asList(strs));
    }

}