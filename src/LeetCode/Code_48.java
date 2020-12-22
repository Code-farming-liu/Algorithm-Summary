package LeetCode;

/**
 * @ClassName: Test60
 * @Description: 旋转图像
 * 题目描述：
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * @Author: Admin
 **/

public class Code_48 {
    //转置 之后在交换列

    /**
     * @param matrix
     * @Author: Admin
     * @Description: 思路分析：
     * <p>
     * 转置矩阵，然后对应的交换 交换开始和结束列 每次重置开始和结束列
     * @return: void
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        //先转置 也就是行变成列 列变成行
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }
        //将对应的列和进行交换 因为 交换 只需要 一半即可
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    //划分 4个矩形

    /**
     * @param matrix
     * @Author: Admin
     * @Description: 思路分析：
     *
     * 将给定的矩阵分成四个矩形
     * 假如是
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 那么 将 1 4 7 、7 8 9、3 6 9 、1 2 3分别划分 将其划分为4个矩形
     * 并且将原问题划归为旋转这些矩形的问题
     *
     * 现在的解法很直接 - 可以在第一个矩形中移动元素并且在 长度为 4 个元素的临时列表中移动它们。
     * 1 3 9 7 顺时针旋转 之后 2 6 8 4顺时针旋转
     * @return: void
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}