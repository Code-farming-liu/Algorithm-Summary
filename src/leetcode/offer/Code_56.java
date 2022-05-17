package leetcode.offer;


public class Code_56 {
    public int[] singleNumbers(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            res ^= num;
        }
        int right = res & ((~res) + 1);
        int res2 = 0;
        for (int num : nums) {
            if ((num & right) != 0) {
                res2 ^= num;
            }
        }
        return new int[]{res ^ res2, res2};
    }
}
