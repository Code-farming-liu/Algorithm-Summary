package leetcode;

/**
 * @ClassName: Code_123
 * @Description: 买卖股票的最佳时机III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 示例 4：
 * <p>
 * 输入：prices = [1]
 * 输出：0
 * @Author: Admin
 **/

public class Code_123 {
    public int maxProfit(int[] prices) {
        // 代表结果
        if (prices == null || prices.length == 0) {
            return 0;
        }
        return dfs(prices, 0, 0, 0);
    }

    private int dfs(int[] prices, int index, int status, int k) {
        //递归终止条件，数组执行到头了，或者交易了两次了
        if (index == prices.length || k == 2) {
            return 0;
        }
        //定义三个变量，分别记录[不动]、[买]、[卖]
        int a = 0, b = 0, c = 0;
        //保持不动
        a = dfs(prices, index + 1, status, k);
        // 处理卖
        if (status == 1) {
            //递归处理卖的情况，这里需要将k+1，表示执行了一次交易
            b = dfs(prices, index + 1, 0, k + 1) + prices[index];
        } else {
            //递归处理买的情况
            c = dfs(prices, index + 1, 1, k) - prices[index];
        }
        //最终结果就是三个变量中的最大值
        return Math.max(Math.max(a, b), c);
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义三维数组，第i天、交易了多少次、当前的买卖状态
        int[][][] dp = new int[n][3][2];
        //初始化第一天，这里的dp[0][2][1]可以不用管，后面也不会用到
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //dp[i][0][0]相当于初始状态，它只能从初始状态转换来
            dp[i][0][0] = dp[i - 1][0][0];
            //处理第一次买入、第一次卖出
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
            //处理第二次买入、第二次卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
        }
        //返回最大值
        int a = Math.max(dp[n - 1][0][0], dp[n - 1][0][1]);
        int b = Math.max(dp[n - 1][1][0], dp[n - 1][1][1]);
        return Math.max(Math.max(a, b), dp[n - 1][2][0]);
    }

    // 0. 没有操作
    //1. 第⼀次买⼊
    //2. 第⼀次卖出
    //3. 第⼆次买⼊
    //4. 第⼆次卖出
    // dp[i][1]，表示的是第i天，买⼊股票的状态，并不是说⼀定要第i天买⼊股票
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

}