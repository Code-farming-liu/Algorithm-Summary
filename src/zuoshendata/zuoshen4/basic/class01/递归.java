package zuoshendata.zuoshen4.basic.class01;


import zuoshendata.LogarithmArray;

/**
 * @ClassName: 递归
 * @Description: 在一个数组中寻找一个最大值
 * @Author: Admin
 * @Date 2020/12/12 14:54
 **/

public class 递归 {

    public static int getMaxValue(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = left + ((left + right) >> 2);
        int maxLeft = getMaxValue(arr, 0, mid);
        int maxRight = getMaxValue(arr, mid + 1, right);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 5, 8};
        int[] res = LogarithmArray.generateRandomArray(5, 100);
        LogarithmArray.printArray(res);
        System.out.println();
        System.out.println(getMaxValue(res, 0, res.length - 1));
    }
}