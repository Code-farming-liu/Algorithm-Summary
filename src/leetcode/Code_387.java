package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code_387
 * @Description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 *  
 * @Author: Admin
 **/

public class Code_387 {
    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 首先我们遍历一次 使用对应的数组进行计数
     * 之后我们在遍历一次，将数组中的值为1的下标返回即可。
     * @return: int
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 同样的思路我们使用哈希表进行辅助
     * @return: int
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param s
     * @Author: Admin
     * @Description: 思路描述：
     * 我们使用对应的API，看一个字符的开始位置和结束位置是否相同，相同则直接返回该位置下标即可
     * @return: int
     */
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }


    /**
     * @param s
     * @Author: Admin
     * @Description: 小于 26 数组计数 大于26 使用类似双指针,头尾相同证明是一个（使用API）
     * @return: int
     */
    public int firstUniqChar4(String s) {
        // 分成两种情况：
        // 第一种为字符串长度小于26的，遍历字符串
        if (s.length() <= 26) {
            int[] charNum = new int[26];//存储各字符出现次数
            char[] chars = s.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {//第一次遍历,记录各个字符出现次数
                charNum[chars[i] - 'a']++;
            }
            for (int i = 0; i < length; i++) {//第二次遍历，按顺序，如果次数为1，返回下标
                if (charNum[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;//无解
        }

        // 第二种字符串长度大于26，遍历26个字母
        // 反过来，只有26个字符
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }

//    public static void main(String[] args) {
//        firstUniqChar3("leetcode");
//    }
}