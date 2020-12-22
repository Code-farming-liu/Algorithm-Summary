package LeetCode;

import java.util.List;

/**
 * @ClassName: Test76
 * @Description: 三角形的最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * @Author: Admin
 **/

public class Code_120 {
    //递归遍历(超时)

    /**
     * @param triangle
     * @Author: Admin
     * @Description: 还可以使用递归遍历：
     * 递归方程： f(i,j)=min(f(i+1,j),f(i+1,j+1))+triangle[i] [j]
     * @return: int
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        return dfs1(triangle, 0, 0);
    }

    private int dfs1(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j),
                dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * @param triangle
     * @Author: Admin
     * @Description: 还可以使用递归遍历：
     * 递归方程： f(i,j)=min(f(i+1,j),f(i+1,j+1))+triangle[i] [j]
     * @return: int
     */
    //递归 + 记忆化
    Integer[][] memo;

    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(dfs(triangle, i + 1, j),
                dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    //动态规划 反向dp

    /**
     * @param triangle
     * @Author: Admin
     * @Description: 思路描述：
     * 我们首先可以想到的就是 动态规划 状态转移方程 很容易确定出来：
     * 但是这里我们无法确定对应的位置 因此我们从后往前推 反向动态规划
     * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
     * @return: int
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        //反向dp
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * @param triangle
     * @Author: Admin
     * @Description: 在上述代码中，我们定义了一个 NN 行 NN 列 的 dp 数组（NN 是三角形的行数）。
     * 但是在实际递推中我们发现，计算 dp[i][j]只用到了下一行的 dp[i + 1][j] 和 dp[i+1][j+1]。
     * 因此 dp 数组不需要定义 N 行，只要定义 1 行就阔以啦。
     * 所以我们稍微修改一下上述代码，将 i 所在的维度去掉（如下）
     * @return: int
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}