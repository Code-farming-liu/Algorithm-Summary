package zuoshendata.zuoshen4.basic.class01;

/**
 * @ClassName: 希尔排序
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/13 10:07
 **/

public class 希尔排序 {
    public static void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int length = array.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    swap(array, j, j - h);
                }
            }
            h /= 3;
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        sort(array);
        for (int number : array) {
            System.out.print(number + "\t");
        }
    }
}