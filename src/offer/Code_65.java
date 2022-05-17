package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_65
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/3/17 14:14
 **/

public class Code_65 {
    char[][] chars;
    boolean[][] visit;
    char[] matrixs;
    char[] strs;

    public boolean hasPath(String matrix, int rows, int cols, String str) {
        // write code here
        matrixs = matrix.toCharArray();
        strs = str.toCharArray();

        chars = new char[rows][cols];
        visit = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = matrixs[i * cols + j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[i][j] == strs[0]) {
                    boolean[] res = new boolean[1];
                    visit[i][j] = true;
                    dfs(1, i, j, res);
                    visit[i][j] = false;
                    if (res[0]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(int depth, int i, int j, boolean[] res) {
        // 截止条件
        if (res[0] || depth == strs.length) {
            res[0] = true;
            return;
        }
        // 候选人
        for (int[] loc : getNear(i, j, chars.length, chars[0].length)) {
            if (!visit[loc[0]][loc[1]] && chars[loc[0]][loc[1]] == strs[depth]) {
                visit[loc[0]][loc[1]] = true;
                dfs(depth + 1, loc[0], loc[1], res);
                visit[loc[0]][loc[1]] = false;
            }
        }
    }

    public List<int[]> getNear(int i, int j, int x, int y) {
        List<int[]> list = new ArrayList<>();
        if (i - 1 >= 0) {
            list.add(new int[]{i - 1, j});
        }
        if (i + 1 < x) {
            list.add(new int[]{i + 1, j});
        }
        if (j - 1 >= 0) {
            list.add(new int[]{i, j - 1});
        }
        if (j + 1 < y) {
            list.add(new int[]{i, j + 1});
        }
        return list;
    }
}