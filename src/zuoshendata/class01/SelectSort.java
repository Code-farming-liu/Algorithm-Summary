package zuoshendata.class01;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: SelectSort
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 10:56
 **/

public class SelectSort {
    //选择排序
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n - 1
        // 1 ~ n - 1
        // 2 ~ n - 1
        for (int i = 0; i < arr.length - 1; i++) {
            //最小值的位置
            int minIndex = i;
            //i ~ N - 1上找最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    //交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //测试
    public static void main(String[] args) {
        LogarithmArray.logarithmArray();
    }
}