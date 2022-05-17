package zuoshendata.zuoshen4.basic.class01;

/**
 * @ClassName: InsertSort
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/11 17:46
 **/

public class InsertSort {
    public static void insertSortTest(int[] array) {
        int length = array.length;
        if (array == null || length < 2) {
            return;
        }

        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertSort(int[] a) {
        for (int i = 0, j = i; i < a.length - 1; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        insertSort(array);
        for (int number : array) {
            System.out.print(number + "\t");
        }
    }
}