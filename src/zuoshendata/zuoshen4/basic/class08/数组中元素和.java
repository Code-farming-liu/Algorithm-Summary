package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 数组中元素和
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/11 14:38
 **/

public class 数组中元素和 {
    public static boolean isSum(int[] arr, int aim, int i, int sum) {
        if (i == arr.length) {
            return sum == aim;
        }
        return isSum(arr, aim, i + 1, sum)
                || isSum(arr, aim, i + 1, sum + arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 11;
        System.out.println(isSum(arr, aim, 0, 0));
    }
}