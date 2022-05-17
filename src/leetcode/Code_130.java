package leetcode;

import algorithmFourth.WeightedQuiclUnionUF;

/**
 * @ClassName: Code_130
 * @Description: 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @Author: Admin
 **/

public class Code_130 {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        int head = m * n;
        WeightedQuiclUnionUF uf = new WeightedQuiclUnionUF(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(node(i, j), head);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            uf.union(node(i, j), node(i - 1, j));
                        } else if (i + 1 < m && board[i + 1][j] == 'O') {
                            uf.union(node(i, j), node(i + 1, j));
                        } else if (j > 0 && board[i][j - 1] == 'O') {
                            uf.union(node(i, j), node(i, j - 1));
                        } else if (j + 1 < n && board[i][j + 1] == 'O') {
                            uf.union(node(i, j), node(i, j + 1));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(node(i, j), head)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public int node(int i, int j) {
        return i * n + j;
    }
}