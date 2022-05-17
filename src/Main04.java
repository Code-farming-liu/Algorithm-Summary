import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Main04
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/30 11:21
 **/

public class Main04 {
    public static void main(String[] args) {
        String str = "abcabcaa";
        System.out.println(getStr(str));
    }
    public static String getStr(String s) {
        int length = s.length();
        if (length == 0) {
            return null;
        }
        int right = -1;
        Set<Character> set = new HashSet<>();
        int res = 0;
        String resStr = s;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                set.remove(i);
            }
            while (right + 1 < length && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            if (res < set.size()) {
                res = set.size();
                resStr = set.toString();
            }
        }
        return resStr;
    }
}