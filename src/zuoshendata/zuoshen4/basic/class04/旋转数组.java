package zuoshendata.zuoshen4.basic.class04;

/**
 * @ClassName: 旋转数组
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/15 10:48
 **/

public class 旋转数组 {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        while (tR < dR) {
            roteEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void roteEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i != times; i++) {
            temp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = temp;
        }
    }
}