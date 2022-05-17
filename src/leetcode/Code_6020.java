package leetcode;

import java.util.Arrays;

public class Code_6020 {
    public static boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[nums[nums.length - 1] + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(divideArray(nums));
    }
}
