package leetcode;

public class Code_309 {
    // 状态⼀：买⼊股票状态（今天买⼊股票，或者是之前就买⼊了股票然后没有操作）
    //卖出股票状态，这⾥就有两种卖出股票状态
    //状态⼆：两天前就卖出了股票，度过了冷冻期，⼀直没操作，今天保持卖出股票状态
    //状态三：今天卖出了股票
    //状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有⼀天！
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][1]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
