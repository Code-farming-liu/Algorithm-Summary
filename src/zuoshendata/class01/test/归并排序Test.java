package zuoshendata.class01.test;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: 归并排序
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/12 16:50
 **/

public class 归并排序Test {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sortProcess(arr, left, mid);
        sortProcess(arr, mid + 1, right);
        merge(arr, left, mid , right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        LogarithmArray.logarithmArray();
    }
}