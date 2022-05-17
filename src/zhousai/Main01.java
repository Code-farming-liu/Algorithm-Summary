package zhousai;

import java.util.Arrays;

/**
 * @ClassName: Main01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/8/29 10:37
 **/

public class Main01 {
    public static void main(String[] args) {
        int[] nums = {30266,74974,6275,5926};
        System.out.println(minimumDifference(nums, 1));
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 2 || k == 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i == k - 1) {
                    res = Math.min(res, nums[j] - nums[i]);
                    break;
                }
            }
        }
        return res;
    }
}