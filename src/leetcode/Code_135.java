package leetcode;

/**
 * @ClassName: Code_135
 * @Description: 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * @Author: Admin
 **/

public class Code_135 {
    // 动态规划

    /**
     * @param ratings
     * @Author: Admin
     * @Description:
     * dp[i] 代表当前小朋友的糖果数量，第一个小朋友一定有一颗 ，
     * 之后遍历如果下一个小朋友的评分比上一个小朋友的评分高，
     * 那么下一个小朋友的糖果数量是上一个小朋友的糖果数量 + 1
     * 之后再去回溯判断 小朋友的糖果数量是不是满足评分，不满足要给前面的
     * 小朋友加糖果
     * @return: int
     */

    public int candy1(int[] ratings) {
        int res = 0;
        //dp的第i项表示第i个孩子应该发多少颗糖果
        int[] dp = new int[ratings.length];
        //初始第一个孩子拿一颗
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            //如果第i个孩子评分比第i-1个孩子高，则比第i-1个孩子拿多一颗糖果
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                //如果第i个孩子评分比第i-1个孩子相等，则先拿最少一颗糖果
            } else if (ratings[i] == ratings[i - 1]) {
                dp[i] = 1;
            } else {
                //如果第i个孩子评分比第i-1个孩子低，则先拿最少一颗糖果
                dp[i] = 1;
                //回溯i之前的孩子，如果前面的孩子拿的糖果比第i个孩子少并且评分比他高，
                //那么要给前面的孩子加糖果
                for (int j = i; j >= 0; j--) {
                    if (j - 1 >= 0 && ratings[j] < ratings[j - 1] && dp[j] == dp[j - 1]) {
                        dp[j - 1]++;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i : dp) {
            res += i;
        }
        return res;
    }

    // 同样的思路优化代码
    public int candy(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int[] candies = new int[ratings.length];
        int pre = ratings[0];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > pre) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
            pre = ratings[i];
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }
        int result = 0;
        for (int num : candies) {
            result += num;
        }
        return result;
    }
}