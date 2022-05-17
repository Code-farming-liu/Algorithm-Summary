package leetcode;

/**
 * @ClassName: Code_5876
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/19 10:34
 **/

public class Code_5876 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(sumOfBeauties(nums));
    }

    public static int sumOfBeauties(int[] nums) {
        int res = 0;
        boolean helper = helper(nums);
        for (int i = 1; i <= nums.length - 2; i++) {
            int j = i - 1, k = i + 1;
            if (helper) {
                res += 2;
            } else if (nums[j] < nums[i] && nums[i] < nums[k]) {
                res += 1;
            }
        }
        return res;
    }

    public static boolean helper(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = (right + left) >>> 1;
            if (nums[left] >= nums[right]) {
                return false;
            }
            if (nums[left] >= nums[mid] || nums[right] <= nums[mid]) {
                return false;
            }
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return true;
    }
}