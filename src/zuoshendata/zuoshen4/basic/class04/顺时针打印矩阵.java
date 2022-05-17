package zuoshendata.zuoshen4.basic.class04;

/**
 * @ClassName: 顺时针打印矩阵
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/15 10:09
 **/

public class 顺时针打印矩阵 {
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
     * @Date 10:10 2020/12/15
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