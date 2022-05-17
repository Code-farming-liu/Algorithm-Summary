package zuoshendata;

/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/3/23 16:26
 **/

public class Test01 {

    public static void quickSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            swap(array, (left + (int)Math.random() * (right - left + 1)), right);
            int[] p = process(array, left, right);
            quickSort(array, left, p[0] - 1);
            quickSort(array, p[1] + 1, right);
        }
    }

    private static int[] process(int[] array, int left, int right) {
        int p1 = left - 1;
        int p2 = right;
        int cur = left;
        while (cur < p2) {
            if (array[cur] < array[right]) {
                swap(array, cur++, ++p1);
            } else if (array[cur] > array[right]) {
                swap(array, cur, --p2);
            } else {
                cur++;
            }
        }
        swap(array, p2, right);
        return new int[]{p1 + 1, p2};
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        quickSort(new int[]{5, 2, 3, 1});
    }
}