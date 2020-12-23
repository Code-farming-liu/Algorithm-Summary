package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Test66
 * @Description: 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * @Author: Admin
 **/

public class Code_73 {
    /**
     * @param matrix
     * @Author: Admin
     * @Description: 思路描述：
     * 解法一
     * 我们扫描一遍原始矩阵，找到所有为零的元素。
     * 如果我们找到 [i, j] 的元素值为零，我们需要记录下行号 i 和列号 j。
     * 用两个 sets ，一个记录行信息一个记录列信息。
     * 最后，我们迭代原始矩阵，对于每个格子检查行 r 和列 c 是否被标记过，如果是就将矩阵格子的值设为 0。
     * @return: void
     */
    public void setZeroes1(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * @param matrix
     * @Author: Admin
     * @Description: 解法二
     * 遍历原始矩阵，如果发现如果某个元素 cell[i][j] 为 0，我们将第 i 行和第 j 列的所有非零元素设成很大的负虚拟值（比如说 -1000000）。注意，正确的虚拟值取值依赖于问题的约束，任何允许值范围外的数字都可以作为虚拟之。
     * 最后，我们便利整个矩阵将所有等于虚拟值（常量在代码中初始化为 MODIFIED）的元素设为 0。
     * @return: void
     */
    public void setZeroes(int[][] matrix) {
        int MODIFIED = -1000000;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0) {
                    //将对应的行和列设置为MODIFIED
                    for (int k = 0; k < C; k++) {
                        if (matrix[r][k] != 0) {
                            matrix[r][k] = MODIFIED;
                        }
                    }
                    for (int k = 0; k < R; k++) {
                        if (matrix[k][c] != 0) {
                            matrix[k][c] = MODIFIED;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                //将MODIFIED 替换为0
                if (matrix[r][c] == MODIFIED) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

    /**
     * 算法
     * <p>
     * 遍历整个矩阵，如果 cell[i][j] == 0 就将第 i 行和第 j 列的第一个元素标记。
     * 第一行和第一列的标记是相同的，都是 cell[0][0]，所以需要一个额外的变量告知第一列是否被标记，
     * 同时用 cell[0][0] 继续表示第一行的标记。
     * 然后，从第二行第二列的元素开始遍历，如果第 r 行或者第 c 列被标记了，那么就将 cell[r][c] 设为 0。
     * 这里第一行和第一列的作用就相当于方法一中的 row_set 和 column_set 。
     * 然后我们检查是否 cell[0][0] == 0 ，如果是则赋值第一行的元素为零。
     * 然后检查第一列是否被标记，如果是则赋值第一列的元素为零。
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            //将第一列用独有的isCol 标记
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                //如果有一个元素为0 则将该元素的行和列的第一个元素置为0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //循环判断当前元素的行和列的第一个元素是不是0，是0则将该行该列元素置为0
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //如果第一个元素为0 则将对应的行设置为0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        //如果当前的第一列的元素也为0 将第一列的所有元素设置为0
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}