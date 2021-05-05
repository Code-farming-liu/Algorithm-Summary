package leetcode;

/**
 * @ClassName: Code_740
 * @Description: 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * @Author: Admin
 **/

public class Code_740 {
    /**
     * @Author: Admin
     * @Description:
     * 可以理解为打家劫舍，然后将全部相同的值全部偷走
     *
     * 1. 如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
     * 2. 如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
     *    以上两个结果，你每次取最大的，记录下来，然后答案就是最后那个数字了。
     *
     * 我们在原来的 nums 的基础上构造一个临时的数组 `all`，这个数组，以元素的值来做下标，下标对应的元素是原来的元素的个数。
     *
     * 例如:
     *
     * nums = [2,2,3,3,3.4]
     *
     * count = [0,0,2,3,1] 记录原数组中数字出现的次数
     *
     * 就是代表着 2 的个数有2个，3 的个数有 3 个，4 的个数有 1 个。
     *
     * 其实这样就可以变成打家劫舍的问题
     *
     * dp[i] 数组第i个数能获得最大点数即为dp[i]
     *
     * dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
     *
     * 第一次偷了一个2之后，会删掉所有的1和3，由于可以偷任意一个，选择继续偷2的话，不会再删除其他元素，结果必然比只偷一个2优,连带删除
     * @param nums
     * @return: int
     */
    public int deleteAndEarn(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        for (int num : nums) {
            all[num]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }
}