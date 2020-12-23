package LeetCode;

import java.util.Arrays;

/**
 * @ClassName: Test100
 * Description:零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
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

public class Code_322 {

    //dfs + 贪心算法
    /**
     * @Author: Admin
     * @Description: 思路描述；
     *
     * 贪心
     * 11. 想要总硬币数最少，肯定是优先用大面值硬币，所以对 coins 按从大到小排序
     * 12. 先丢大硬币，再丢会超过总额时，就可以递归下一层丢的是稍小面值的硬币
     *
     * 贪心
     * 11. 想要总硬币数最少，肯定是优先用大面值硬币，所以对 coins 按从大到小排序
     * 12. 先丢大硬币，再丢会超过总额时，就可以递归下一层丢的是稍小面值的硬币
     *
     * 乘法对加法的加速
     * 21. 优先丢大硬币进去尝试，也没必要一个一个丢，可以用乘法算一下最多能丢几个
     *
     * k = amount / coins[c_index] 计算最大能投几个
     * amount - k * coins[c_index] 减去扔了 k 个硬币
     * count + k 加 k 个硬币
     *
     * 如果因为丢多了导致最后无法凑出总额，再回溯减少大硬币数量
     * 最先找到的并不是最优解
     * 31. 注意不是现实中发行的硬币，面值组合规划合理，会有奇葩情况
     * 32. 考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到
     * 33. 所以还是需要把所有情况都递归完
     *
     * ans 疯狂剪枝
     * 41. 贪心虽然得不到最优解，但也不是没用的
     * 42. 我们快速算出一个贪心的 ans 之后，虽然还会有奇葩情况，但是绝大部分普通情况就可以疯狂剪枝了
     * @param null
     * @return: null
     */
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