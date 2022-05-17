package zuoshendata.class01.test;

/**
 * @ClassName: TestBEExistNearLeft
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 14:54
 **/

public class TestBEExistNearLeft {
    public static int BEExistNearLeft(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if(arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}