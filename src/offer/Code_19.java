package offer;

import java.util.ArrayList;

/**
 * @ClassName: Test19
 * @Description: 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author: Admin
 **/

public class Code_19 {
    /**
     * @param matrix
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以看个例子
     * 1 2 3
     * 4 5 6 --------------顺时针打印
     * 7 8 9
     * <p>
     * 1 2 3 6 9 8 7 4 5
     * 我们可以定义4个指针（因为方向只有上下左右）down up left right
     * 刚开始指针肯定是向右移动，因此我们直接让一个变量指向左指针，开始遍历 直到到达边界
     * 其他方向也是如此
     * 总结
     * 也就是先右------在下---------在左--------在上---------循环执行过程，判断中途是否越界。
     * @return: java.util.ArrayList<java.lang.Integer>
     */
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

    /**
     * tR 左上角的行
     * tC 左上角的列
     * dR 右下角行
     * dC 右下角列
     **/
    public static void printMain(int[][] m) {
        int tR = 0;
        int tC = 0;
        int dR = m.length - 1;
        int dC = m[0].length - 1;
        // 左上角的行小于等于 右下角的行
        // 左上角的列小于等于 右下角的列
        while (tR <= dR && tC <= dC) {
            printEdge(m, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * @param m  目标数组
     * @param tR 左上角的行
     * @param tC 左上角的列
     * @param dR 右下角行
     * @param dC 右下角列
     * @return void
     * @Author Admin
     * @Description
     **/

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            // 在同一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            // 在同一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                System.out.print(m[tR][curC++] + " ");
            }
            while (curR != dR) {
                System.out.print(m[curR++][dC]);
            }
            while (curC != tC) {
                System.out.print(m[dR][curC--] + " ");
            }
            while (curR != tR) {
                System.out.print(m[curR--][tC] + " ");
            }
        }
    }
}