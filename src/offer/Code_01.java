package offer;

/**
 * @Description: 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * @Author: Admin
 **/

public class Code_01 {
    /**
     * @param target
     * @param array
     * @return boolean
     * @Author Admin
     * @Description 思路描述：
     * 我们利用 从左到右，从上到下递增的特点。
     * 我们从左下角开始查找
     * 如果目标值大于当前值，当前值则向右移动。注意防止越界 ，如果越界， 则说明没有找到 ，返回false
     * 如果目标值小于当前值，当前值则向上移动。注意防止越界， 如果越界， 则说明没有找到 ，返回false
     * 否则说明找到了 返回 true。
     **/
    public boolean Find(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int row = m - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (target > array[row][col]) {
                col++;
            } else if (target < array[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}