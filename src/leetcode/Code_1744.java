package leetcode;

/**
 * @ClassName: Code_1744
 * @Description: 你能在你最喜欢的那天吃到你最喜欢吃的糖果吗？
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * <p>
 * 你按照如下规则进行一场游戏：
 * <p>
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <p>
 * 请你返回得到的数组 answer 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 * <p>
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 * @Author: Admin
 **/

public class Code_1744 {
    public static boolean[] canEat(int[] cs, int[][] qs) {
        int n = qs.length, m = cs.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            // 求出每堆糖前面还有多少颗糖
            sum[i] = sum[i - 1] + cs[i - 1];
        }
        for (int i = 0; i < n; i++) {
            // t = favoriteTypei
            // d = favoriteDayi
            // c = dailyCapi
            int t = qs[i][0], d = qs[i][1] + 1, c = qs[i][2];
            // a: 吃完t类前面那么多糖的最少天数 (每天吃 c)
            // b: 吃完t类前面那么多糖的最大天数 (每天吃 1)
            long a = sum[t] / c + 1, b = sum[t + 1];
            // 结果只要是在 [a, b]区间内都可以吃到自己的糖
            ans[i] = a <= d && d <= b;
        }
        return ans;
    }
//    作者：AC_OIer
//    链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/solution/gong-shui-san-xie-qian-zhui-he-qiu-jie-c-b38y/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        int[] candiesCount = {7, 4, 5, 3, 8};
        int[][] queries = {
                {0, 2, 2},
                {4, 2, 4},
                {2, 13, 1000000000},
        };
        canEat(candiesCount, queries);
    }
}