package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Test65
 * @Description: 不同路径
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * @Author: Admin
 **/ 

public class Code_62 {
    /**
     * @param m
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 当前位置只与当前位置的左边 和 上边的状态有关，因此到达当前位置，
     * 那么就是从上边到达这个位置和从下边到达这个位置的和，因此可以采用动态规划
     *
     * 当前的状态只跟上一行的状态和同一行左边的状态有关。所以我们只需要维护上一行的数组，
     * 和当前行的数组
     *
     * 一维的dp数组定义为当前行中，每个元素对应的步数。
     * 对于二维数组dp[i] [j] = dp[i-1] [j] + dp[i] [j-1],
     * 对于一维数组， 对于第i行来说，dp[j] = dp[j] + dp[j-1],
     * 等号右边的未赋值之前的dp[j]就是上一行的第j个数据对应的步数， 还未更新
     * 即dp[i-1] [j] 等号右边的dp[j-1]是已经更新过的本行的第j-1个数据对应的步数，
     * 即dp[i] [j-1] 则，本行的dp[j] = 上一行的dp[j] + 本行的dp[j-1]，
     * 所以dp[j] = dp[j] + dp[j-1].
     *
     * 因此可以优化动态规划
     * 双数组
     * 单数组
     * @return: int
     */
    public int uniquePaths(int m, int n) {
        if (m < 2 || n < 2) {
            return 1;
        }
        if (m == 2) {
            return n;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //相当于是终点的左边那个点(i-1,j)和上面那个点(i,j-1)，
                // 都可以一步到达终点，没有其他的选择。所以到达最后一个点(i,j)的方式，
                // 就是到达(i-1,j)的所有方式和到达(i,j-1)的所有方式之和。
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


// 当前的状态只跟上一行的状态和同一行左边的状态有关。所以我们只需要维护上一行的数组，和当前行的数组
//
//
// 一维的dp数组定义为当前行中，每个元素对应的步数。
// 对于二维数组dp[i][j] = dp[i-1][j] + dp[i][j-1],
// 对于一维数组， 对于第i行来说，dp[j] = dp[j] + dp[j-1],
// 等号右边的未赋值之前的dp[j]就是上一行的第j个数据对应的步数，还未更新
// 即dp[i-1][j] 等号右边的dp[j-1]是已经更新过的本行的第j-1个数据对应的步数，
// 即dp[i][j-1] 则，本行的dp[j] = 上一行的dp[j] + 本行的dp[j-1]，
// 所以dp[j] = dp[j] + dp[j-1].


    public static int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n - 1];
    }

    public static int uniquePaths3(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
