package leetcode;

/**
 * @ClassName: Code_221
 * @Description: 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 * @Author: Admin
 **/

public class Code_221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;
        int currentMaxSide = 0;
        int res = 0;
        boolean flag;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    // 可能的最大正方形边长
                    currentMaxSide = Math.min(m - i, n - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断正方形的右下角是否为1 判断新增的一行一列是否均为1
                        flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int d = 0; d < k; d++) {
                            if (matrix[i + k][j + d] == '0' || matrix[i + d][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        res = maxSide * maxSide;
        return res;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(maximalSquare(chars));
    }
}