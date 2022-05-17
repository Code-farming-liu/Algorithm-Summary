package leetcode;

public class Code_188 {
    // j的状态表示为：
    //0 表示不操作
    //1 第⼀次买⼊
    //2 第⼀次卖出
    //3 第⼆次买⼊
    //4 第⼆次卖出
    //.....
    //⼤家应该发现规律了吧 ，除了0以外，偶数就是卖出，奇数就是买⼊
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][k * 2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1};
        new Code_188().maxProfit(2, nums);
    }
}
