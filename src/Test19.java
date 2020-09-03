import java.util.ArrayList;

/**
 * @ClassName: Test19
 * @Description: 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @Author: Admin
 **/

public class Test19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int down = 0;
        int up = m - 1;
        int left = 0;
        int right = n - 1;
        while(true) {
            for(int col = left; col <= right; col++){
                res.add(matrix[down][col]);
            }
            //向下走
            down++;
            if(down > up){
                break;
            }
            for(int row = down; row <= up; row++){
                res.add(matrix[row][right]);
            }
            //向左走
            right--;
            if(right < left){
                break;
            }
            for(int col = right; col >= left; col--) {
                res.add(matrix[up][col]);
            }
            //向上走
            up--;
            if(up < down){
                break;
            }
            for(int row = up; row >= down; row--) {
                res.add(matrix[row][left]);
            }
            left++;
            if(left > right){
                break;
            }

        }
        return res;
    }
}