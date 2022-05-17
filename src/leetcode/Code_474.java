package leetcode;

/**
 * @ClassName: Code_474
 * @Description: 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * @Author: Admin
 **/

public class Code_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 预处理每一个字符包含 0 和 1 的数量
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            cnt[i] = new int[]{zero, one};
        }

        // 处理只考虑第一件物品的情况
        int[][][] f = new int[len][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[0][i][j] = (i >= cnt[0][0] && j >= cnt[0][1]) ? 1 : 0;
            }
        }

        // 处理考虑其余物品的情况
        for (int k = 1; k < len; k++) {
            int zero = cnt[k][0], one = cnt[k][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    // 不选择第 k 件物品
                    int a = f[k-1][i][j];
                    // 选择第 k 件物品（前提是有足够的 m 和 n 额度可使用）
                    int b = (i >= zero && j >= one) ? f[k-1][i-zero][j-one] + 1 : 0;
                    f[k][i][j] = Math.max(a, b);
                }
            }
        }
        return f[len-1][m][n];
    }
}