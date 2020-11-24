import java.util.Arrays;

/**
 * @ClassName: Test100
 * Description:零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * @Author: Admin
 **/

public class Test100 {

    //dfs + 贪心算法
    int result = Integer.MAX_VALUE; //最后最优解

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length - 1, coins, 0, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * @param index      coins的下标
     * @param coins      硬币面值数组
     * @param count      统计硬币的个数
     * @param needAmount 所需要的总金额
     */
    private void coinChange(int index, int[] coins, int count, int needAmount) {
        if (needAmount == 0) {
            result = Math.min(result, count);
            return;
        }
        if (index < 0) {
            return;
        }
        //利用乘除 解决加法问题
        //i + count < result 这个 硬币数目小于当前硬币的最优解才会进行替换，否则不替换
        for (int i = needAmount / coins[index]; i >= 0 && i + count < result; i--) {
            //最大的不能直接成功则进行次小的
            coinChange(index - 1, coins, count + i, needAmount - i * coins[index]);
        }
    }
}