/**
 * @ClassName: Test97
 * Description:完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * @Author: Admin
 **/

public class Test97 {
    //dfs + 贪心算法
    int res = Integer.MAX_VALUE;

    public int numSquares(int n) {
        int a = (int) Math.floor(Math.sqrt(n)); //向下取整 找到最大的完全平方数
        int[] num = new int[a]; //创建对应的数组
        for (int i = 0; i < a; i++) {
            num[i] = i + 1;
        }
        numChange(num.length - 1, num, 0, n);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private void numChange(int index, int[] num, int count, int n) {
        if (n == 0) {
            res = Math.min(res, count);
        }
        if (index < 0) {
            return;
        }
        //i + count < res  这个是当前的个数和我们的res 进行比较 如果小于才进行替换 否则无意义
        //n / (num[index] * num[index]) 这个 利用乘除 代替加减
        for (int i = n / (num[index] * num[index]); i >= 0 && i + count < res; i--) {
            numChange(index - 1, num, count + i, n - i * num[index] * num[index]);
        }
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}