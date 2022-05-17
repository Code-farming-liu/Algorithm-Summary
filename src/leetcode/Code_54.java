package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_54
 * @Description: 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @Author: Admin
 **/

public class Code_54 {
    /**
     * @param matrix
     * @Author: Admin
     * @Description: 我们将矩阵分层打印。
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }

                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int down = 0;
        int up = m - 1;
        int left = 0;
        int right = n - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                res.add(matrix[down][col]);
            }
            //向下走
            down++;
            if (down > up) {
                break;
            }
            for (int row = down; row <= up; row++) {
                res.add(matrix[row][right]);
            }
            //向左走
            right--;
            if (right < left) {
                break;
            }
            for (int col = right; col >= left; col--) {
                res.add(matrix[up][col]);
            }
            //向上走
            up--;
            if (up < down) {
                break;
            }
            for (int row = up; row >= down; row--) {
                res.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }


    public List<Integer> printMatrix2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        while (up <= down && left <= right) {
            // 向右走
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            // 向下走
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (up < down && left < right) {
                // 向左走
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[down][i]);
                }
                // 向上走
                for (int i = down - 1; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}