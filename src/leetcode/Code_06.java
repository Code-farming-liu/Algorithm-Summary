package leetcode;


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *  
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 */
public class Code_06 {
    // 纯暴力模拟
    public static String convert1(String s, int numRows) {
        int n = s.length();
        char[][] chars = new char[numRows][n];
        int up = 0, col = 0;
        if (n < 3 || numRows < 2) {
            return s;
        }
        for (int i = 0; i < n;) {
            while (up < numRows && i < n) {
                chars[up++][col] = s.charAt(i++);
            }
            col++;
            up--;
            while (up - 1 >= 0 && i < n) {
                chars[--up][col++] = s.charAt(i++);
            }
            up++;
            col--;
        }
        printGr(chars);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if (chars[i][j] != 0) {
                    res.append(chars[i][j]);
                }
            }
        }
        return res.toString();
    }

    public static String convert(String s, int r) {
        int n = s.length();
        if (n == 1 || r == 1) return s;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            // 第一行和最后一行
            if (i == 0 || i == r - 1) {
                int pos = i;
                int offset = 2 * (r - 1);
                while (pos < n) {
                    sb.append(s.charAt(pos));
                    pos += offset;
                }
            } else {
                int pos1 = i, pos2 = 2 * r - i - 2;
                int offset = 2 * (r - 1);
                while (pos1 < n || pos2 < n) {
                    if (pos1 < n) {
                        sb.append(s.charAt(pos1));
                        pos1 += offset;
                    }
                    if (pos2 < n) {
                        sb.append(s.charAt(pos2));
                        pos2 += offset;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static void printGr(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str, 3));
    }
}
