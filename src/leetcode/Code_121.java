package leetcode;

/**
 * @ClassName: Code_121
 * @Description: 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @Author: Admin
 **/

public class Code_121 {
    /**
     * @param prices
     * @Author: Admin
     * @Description: 思路描述
     *  我们要想利润最大化，那么我们的买入的价格需要最小，
     *  卖出的价格相对来说是需要最大，每次我们都更新利润
     * @return: int
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        // 最大的利润
        int res = 0;
        // 初始化为 第一个元素,也就是买的时候需要最小的价格
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                continue;
            }
            // 每次更新对应的利润
            res = Math.max(prices[i] - min, res);
        }
        return res;
    }
}