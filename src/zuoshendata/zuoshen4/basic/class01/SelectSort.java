package zuoshendata.zuoshen4.basic.class01;

/**
 * @ClassName: SelectSort
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/11 17:40
 **/

public class SelectSort {
    public static void selectSortTest(int[] array) {
        int length = array.length;
        if (array == null || length < 2) {
            return;
        }

        for (int i = 0; i < length - 1; i++) {
            //最小数的下标
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}