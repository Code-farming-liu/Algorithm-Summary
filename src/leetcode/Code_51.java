package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 八皇后
public class Code_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        dfs(res, board, n, 0);
        return res;
    }

    public void dfs(List<List<String>> res, char[][] chars, int n, int row) {
        // 结束条件
        if (row == n) {
            res.add(charToList(chars));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isCheck(row, col, chars, n)) {
                chars[row][col] = 'Q';
                dfs(res, chars, n, row + 1);
                chars[row][col] = '.';
            }
        }
    }

    private boolean isCheck(int row, int col, char[][] chars, int n) {
        // 检查列
        for (int i = 0; i < n; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度角
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][i] == 'Q') {
                return false;
            }
        }
        // 检查135度
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> charToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
