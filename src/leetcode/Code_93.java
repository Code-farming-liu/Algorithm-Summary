package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Code_93
 * @Description: 复原IP地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * @Author: Admin
 **/

public class Code_93 {
    private List<String> res;
    private StringBuilder path;
    private String s;

    public List<String> restoreIpAddresses(String s) {
        this.res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        this.s = s;
        path = new StringBuilder();
        dfs(0, 3);
        return res;
    }

    // start 表示截取子串的起点
    // resNum 表示剩余的ip段个数
    private void dfs(int start, int resNum) {
        // 如果所有ip段都已经找完了，添加答案到集合中并返回
        if (resNum == -1 && start == s.length()) {
            // 删除最后添加的点号
            path.setLength(path.length() - 1);
            res.add(path.toString());
            return;
        }
        // 如果遍历完字符串还没有找完ip，提前返回
        if (start == s.length()) {
            return;
        }

        char[] c = s.toCharArray();
        int pathLen = path.length();
        int len = c.length;

        // 子串右边界范围必须同时满足两个条件，取范围的交集
        // 1. 根据数字最多不能超过三位，最少一位得出：[start + 1, start + 3]
        // 2. 根据剩余还需要拼接的ip地址个数得出：[len - 3 * resNum, len - resNum]
        int max = Math.min(start + 3, len - resNum);
        int min = Math.max(start + 1, len - 3 * resNum);
        for (int i = min; i <= max; i++) {
            // 第一个字符为0，剪支
            if (i > start + 1 && c[start] == '0') {
                break;
            }

            // 当前的数字越界，剪支
            String sub = s.substring(start, i);
            int num = Integer.parseInt(sub);
            if (num > 255) {
                break;
            }

            path.append(sub).append(".");
            dfs(i, resNum - 1);
            path.setLength(pathLen);
        }
    }


    public List<String> restoreIpAddresses1(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs1(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    /**
     * @param s
     * @param len
     * @param begin   截取的开始下标
     * @param residue 剩余多少段
     * @param path
     * @param res
     */
    private void dfs1(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            // 后续的s 还是有剩余
            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);
                dfs1(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }


//    private  res;
    public static List<String> restoreIpAddresses3(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) { //特判
            return res;
        }
        backTracking(new StringBuilder(s), 0, 0, res);
        return res;
    }


    private static void backTracking(StringBuilder s, int start, int pointNum, List<String> res) {
        if (pointNum == 3) {
            if (isValid(s, start, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s = new StringBuilder(s.substring(0, i + 1)).append('.').append(s.substring(i + 1));
                pointNum++;
                backTracking(s, i + 2, pointNum, res); //加了一个'.'下个起始点变成了i + 2
                pointNum--;
                s = new StringBuilder(s.substring(0, i + 1)).append(s.substring(i + 2));
            } else {
                break;
            }
        }
    }

    public static boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 判断是否以0开头
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int n = 0;
        for (int i = start; i <= end; i++) {
            // 判断是否有负,是否两位数
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            // 判断是否大于255
            n = n * 10 + (s.charAt(i) - '0');
            if (n > 255) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "25525511135";
        new Code_93().restoreIpAddresses3(str);
    }

}