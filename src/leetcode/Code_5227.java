package leetcode;

public class Code_5227 {
    public int maximumTop(int[] nums, int k) {
        if (nums.length == k % 2) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < Math.min(nums.length, k - 1); i++) {
            max = Math.max(max, nums[i]);
        }
        return Math.max(max, nums.length > k ? nums[k] : 0);
    }

    public static void main(String[] args) {
        int[] nums = {91,98,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,
                29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,
                41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49};
        System.out.println(new Code_5227().maximumTop(nums, 2)); // 94
    }
}
