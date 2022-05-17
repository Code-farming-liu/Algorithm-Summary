package zuoshendata.zuoshen4.basic.class01;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: BubbleSort
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/11 17:31
 **/

public class BubbleSort {
    public static void bubbleSortTest(int[] arr) {
        int length = arr.length;
        if (arr == null || length < 2) {
            return;
        }

        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LogarithmArray.logarithmArray();
    }

}