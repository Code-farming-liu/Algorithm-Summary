package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 换钱
 * @Description: 给定面值货币 有多少种方法 能凑够 给的目标值，每一张货币 可以使用 0次 或 多次
 * @Author: Admin
 * @Date 2020/12/11 15:20
 **/

public class 换钱 {
    public static int coins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= arr.length; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }
}