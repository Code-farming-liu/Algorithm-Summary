/**
 * @Description:题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * @Author: Admin
 **/

public class Test01 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        int n = array[0].length;
        int row = m - 1;
        int col = 0;
        while(row >= 0 && col < n){
            if(target > array[row][col]){
                col++;
            } else if(target < array[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}