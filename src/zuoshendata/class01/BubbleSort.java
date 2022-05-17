package zuoshendata.class01;

/**
 * @ClassName: BubbleSort
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 11:19
 **/

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ N - 1
        // 0 ~ N - 2
        // 0 ~ N - 3
        // i 控制 0 ~ i
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}