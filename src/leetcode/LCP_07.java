package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: LCP_07
 * @Description: 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 * @Author: Admin
 **/

public class LCP_07 {
//    public int[] findErrorNums(int[] nums) {
//        int[] res = new int[2];
//        int length = nums.length;
//        int[] count = new int[length + 1];
//        for (int num : nums) {
//            count[num]++;
//        }
//        for (int i = 1; i <= length; i++) {
//            if (count[i] == 0) {
//                res[1] = i;
//            }
//            if (count[i] == 2) {
//                res[0] = i;
//            }
//        }
//        return res;
//    }
    public static void greedySelector(double[][] time) {
        double[] start = new double[time.length];
        double[] end = new double[time.length];
        for (int i = 0; i < time.length; i++) {
            start[i] = time[i][0];
            end[i] = time[i][1];
        }
        int j = 0;
        int count = 0;
        int n = start.length - 1;
        for (int i = 1; i <= n; i++) {
            if (start[i] >= end[j]) {
                j = i;
                count++;
            }
        }
        System.out.println("总的活动数量 = " + count);
    }

    public static void main(String[] args) {
        double[][] res = new double[4][2];
        res[0][0] = 0.0;
        res[0][1] = 0.0;
        res[1][0] = 10.0;
        res[1][1] = 12.0;
        res[2][0] = 3.0;
        res[2][1] = 11.30;
        res[3][0] = 11.30;
        res[3][1] = 14.0;
        Arrays.sort(res, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                return (int) (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            }
        });
        greedySelector(res);
    }
}