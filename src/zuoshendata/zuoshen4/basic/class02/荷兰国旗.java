package zuoshendata.zuoshen4.basic.class02;

/**
 * @ClassName: 荷兰国旗
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/13 9:14
 **/

public class 荷兰国旗 {

    public static int[] partition(int[] arr,int left, int right, int p) {
        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < p) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > p) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}