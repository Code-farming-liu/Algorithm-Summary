package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 矩阵最小路径和
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/9 9:07
 **/

public class 矩阵最小路径和 {
    public static int process1(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process1(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process1(matrix, i - 1, j);
        }
        return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
    }

    public static int process2(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        //已经在右下角
        if (i == m && j == n) {
            return matrix[i][j];
        }
        //在最后一行
        if (i == m && j < n) {
            return process2(matrix, i, j + 1) + matrix[i][j];
        }
        //在最后一列
        if (i < m && j == n) {
            return process2(matrix, i + 1, j) + matrix[i][j];
        }
        //左边的位置到右下角的最短路径和
        int right = process2(matrix, i, j + 1);
        //下边的位置到右下角的最短路径和
        int down = process2(matrix, i + 1, j);
        return Math.min(right, down) + matrix[i][j];
    }

//    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        Integer res = map.put(1, 1);
//        map.put(1, 2);
//        map.put(2, 1);
//        System.out.println(res);
//    }

}