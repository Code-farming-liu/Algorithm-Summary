package zuoshendata.zuoshen4.basic.class02;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: 随机快排
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 10:44
 **/

public class 随机快排 {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int)(Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int start = left - 1;
        int end = right;
        int cur = left;
        while (cur < end) {
            if (arr[cur] < arr[right]) {
                swap(arr, ++start, cur++);
            } else if (arr[cur] > arr[right]) {
                swap(arr, --end, cur);
            } else {
                cur++;
            }
        }
        swap(arr, end, right);
        return new int[] {start + 1, end};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LogarithmArray.logarithmArray();
//        int[] res = LogarithmArray.generateRandomArray(10, 100);
//        quickSort(res);
    }
}