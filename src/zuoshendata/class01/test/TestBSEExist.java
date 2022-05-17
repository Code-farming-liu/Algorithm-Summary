package zuoshendata.class01.test;

/**
 * @ClassName: TestBSEExist
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 14:33
 **/

public class TestBSEExist {
    public boolean BSEExists(int[] arr, int value) {
        if (arr == null) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (value == arr[mid]) {
                return true;
            } else if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left] == value;
    }
}