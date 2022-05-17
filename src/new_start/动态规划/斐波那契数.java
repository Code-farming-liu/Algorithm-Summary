package new_start.动态规划;

public class 斐波那契数 {
    public int fib1(int n) {
        //1. 确定dp数组（dp table）以及下标的含义
        // dp[i] 代表i的时候斐波那契数值是多少
        //2. 确定递推公式
        // dp[i] = dp[i - 1] + dp[i - 2]
        //3. dp数组如何初始化
        // dp[0] = 0, dp[1] = 1
        //4. 确定遍历顺序
        // 正序遍历
        //5. 举例推导dp数组
        // 0 1 1 2 3 5
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib(int n) {
        //1. 确定dp数组（dp table）以及下标的含义
        // dp[i] 代表i的时候斐波那契数值是多少
        //2. 确定递推公式
        // dp[i] = dp[i - 1] + dp[i - 2]
        //3. dp数组如何初始化
        // dp[0] = 0, dp[1] = 1
        //4. 确定遍历顺序
        // 正序遍历
        //5. 举例推导dp数组
        // 0 1 1 2 3 5
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
