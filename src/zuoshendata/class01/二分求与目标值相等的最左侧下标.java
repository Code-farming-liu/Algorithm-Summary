package zuoshendata.class01;

/**
 * @ClassName: BSEExistNearLeft
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 14:38
 **/

public class 二分求与目标值相等的最左侧下标 {
    //在arr上找满足 >= value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        //记录最左边的正确位置
        int index = -1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}