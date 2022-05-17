package leetcode;

public class Code_688 {
    int n;
    int[] xops = new int[]{-1, -2, -2, -1, 1, 2, 2, 1, -1};
    int[] yops = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        double[][][] memo = new double[n][n][k - 1];
        return dfs(k, row, column, memo);
    }

    public double dfs(int k, int i, int j, double[][][] memo) {
        if (k == 0) {
            return 1;
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        double cnt = 0;
        for (int l = 0; l < 8; l++) {
            int x = i + xops[l];
            int y = j + yops[l];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                cnt += dfs(k - 1, x, y, memo) / 8.0;
            }
        }
        memo[i][j][k] = cnt;
        return cnt;
    }
}
