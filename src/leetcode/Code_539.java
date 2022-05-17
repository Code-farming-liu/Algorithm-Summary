package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 */
public class Code_539 {
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> temp = new ArrayList<>();
        for (String str : timePoints) {
            String[] split = str.split(":");
            int h = help(split[0]);
//            h = h == 0 ? 24 : h;
            int m = help(split[1]);
            int t = h * 60 + m;
//            t = t == 0 ? 1440 : t;
            if (temp.contains(t)) {
                return 0;
            }
            temp.add(t);
        }
        Collections.sort(temp);
        int res = 1500;
        for (int i = 1; i < temp.size(); i++) {
            int a = temp.get(i) - temp.get(i - 1);
            res = Math.min(a, res);
        }
        return Math.min(res, temp.get(0) + 1440 - temp.get(temp.size() - 1));
    }

    public static int help(String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                res = res * 10 + aChar - '0';
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        res.add("12:12");
        res.add("00:13");
//        res.add("00:35");
        System.out.println(findMinDifference(res));
    }
}
