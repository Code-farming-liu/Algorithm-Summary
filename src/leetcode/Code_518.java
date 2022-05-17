package leetcode;

public class Code_518 {
    public int change(int amount, int[] coins) {
        // 如果使⽤⼀维dp数组，物品遍历的for循环放在外层，遍历背包的for循环放在内层，且内层for循环倒叙遍历！
        // 在求装满背包有⼏种⽅法的情况下，递推公式⼀般为：
        // dp[j] += dp[j - nums[i]];
        int[] dp = new int[amount + 1];
        //1. 确定dp数组（dp table）以及下标的含义
        //2. 确定递推公式
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
            print(dp);
        }
        return dp[amount];
        //3. dp数组如何初始化
        //4. 确定遍历顺序
        //5. 举例推导dp数组
    }


    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            print(dp);
        }
        return dp[amount];
    }

    public void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5};
        new Code_518().change1(5, nums);
    }
}
