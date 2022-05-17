package leetcode;

public class Code_2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int total = mean * (rolls.length + n);
        for (int roll : rolls) {
            total -= roll;
        }
        if (total < 0 || total > n * 6 || total < n) {
            return new int[]{};
        }

        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = total / n;
        }
        int t = total % n;
        if (t == 0) {
            return nums;
        } else {
            for (int i = 0; i < n && t > 0; i++) {
                if (nums[i] + t <= 6) {
                    nums[i] = nums[i] + t;
                    break;
                } else {
                    t -= (6 - nums[i]);
                    nums[i] = 6;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        new Code_2028().missingRolls(nums, 2, 53);
    }
}
