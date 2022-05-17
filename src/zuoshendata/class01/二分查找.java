package zuoshendata.class01;

/**
 * @ClassName: BSEExist
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 14:22
 **/

public class 二分查找 {
    public static boolean exist(int[] sortArr, int num) {
        if (sortArr == null || sortArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortArr.length - 1;
        int mid = 0;
        while (L < R) {
            //等价于 mid = (L + R) / 2
            mid = L + ((R - L) >> 1);
            if (sortArr[mid] == num) {
                return true;
            } else if (sortArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortArr[L] == num;
    }
}