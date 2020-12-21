package offer;

/**
 * @ClassName: Test28
 * @Description: 连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
 * 返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @Author: Admin
 **/

public class Code_30 {
    /**
     * @param array
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以采用动态规划方式解决，我们只需要判断前一次 + 本次 与 本次的最大值
     * 举例来说 前一次结果 -3 本次结果 1
     * -3 + 1 = -2 -2 < 1 因此 dp[i] = 1
     * 变量result 每次去 dp[i] 与 result的最大值，
     * 如果result > dp[i] 则不进行交换 还是举例子
     * result = 3 dp[i] = 1 那么我们要找的最大值肯定不需要交换 3 > 1
     * result = 3 dp[i] = 4 那么我们要找的最大值肯定需要去交换 3 < 4
     * result 保证为最大值
     * 最终返回result
     * @return: int
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}