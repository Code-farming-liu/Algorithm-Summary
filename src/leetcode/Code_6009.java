package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code_6009 {
    public static int minSteps(String s, String t) {
        int res = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), map2.get(t.charAt(i)) + 1);
            } else {
                map2.put(t.charAt(i), 1);
            }
        }

        for (Character key : map1.keySet()) {
            if (map2.containsKey(key)) {
                res += (Math.abs(map1.get(key) - map2.get(key)));
                continue;
            }
            res += map1.get(key);
        }
        for (Character key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                res += map2.get(key);
            }
        }
        return res;
    }

    public int minSteps1(String s, String t) {
        int count[] = new int[26], result = s.length();
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            result += count[c - 'a']-- > 0 ? -1 : 1;
        }
        return result;
    }

        public static void main(String[] args) {
        String s = "nxkhahxvqy"; // 6  正确8
        String t = "nbhqyoxwnx";
        System.out.println(minSteps(s, t));
    }
}
