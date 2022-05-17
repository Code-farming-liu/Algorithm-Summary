package leetcode;

/**
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */
public class Code_70 {
    public int climbStairs01(int n) {
        if (n < 2) {
            return n;
        }
        //1. 确定dp数组（dp table）以及下标的含义
        int[] dp = new int[n + 1];
        //2. 确定递推公式
        //3. dp数组如何初始化
        dp[1] = 1;
        dp[2] = 2;
        //4. 确定遍历顺序
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //5. 举例推导dp数组
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
