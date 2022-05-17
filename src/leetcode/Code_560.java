//package leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @ClassName: Code_560
// * @Description: 和为K的子数组
// * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
// *
// *  
// *
// * 示例 1：
// *
// * 输入：nums = [1,1,1], k = 2
// * 输出：2
// * 示例 2：
// *
// * 输入：nums = [1,2,3], k = 3
// * 输出：2
// *
// * @Author: Admin
// * @Date 2021/9/12 9:49
// **/
//
//public class Code_560 {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int length = nums.length;
//        int[] sum = new int[length];
//        sum[0] = nums[0];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 1; i < length; i++) {
//            sum[i] = sum[i - 1] + nums[i];
//            map.put(sum[i], map.get(sum[i]) != null ? map.get(sum[i]) + 1 : 1);
//        }
//        for (int i = 0; i < sum.length; i++) {
//            map.get()
//        }
//    }
//}