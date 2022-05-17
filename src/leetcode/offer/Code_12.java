package leetcode.offer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 *
 */
public class Code_12 {
    private boolean[][] visited;
    private String word;
    private char[][] board;
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        this.word = word;
        this.board = board;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = i + direction[k][0];
                int y = j + direction[k][1];
                if (judge(x, y) && !visited[x][y]) {
                    if (dfs(x, y, start + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean judge(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
