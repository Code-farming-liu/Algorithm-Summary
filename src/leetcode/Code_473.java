package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Code_473
 * @Description: 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 * <p>
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,2,2]
 * 输出: true
 * <p>
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: [3,3,3,3,4]
 * 输出: false
 * <p>
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 * <p>
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 * @Author: Admin
 **/

public class Code_473 {
    boolean flag = false;

    public boolean makesquare(int[] matchsticks) {
        int length = matchsticks.length;
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum == 0 || (sum & 3) != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        backtrack(matchsticks, length - 1, sum >> 2, new int[4]);
        return flag;
    }

    private void backtrack(int[] nums, int index, int target, int[] size) {
        //终止条件(递归必须要有终止条件)
        if (index == -1) {
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3]) {
                flag = true;
                return;
            }
            return;
        }
        if (!flag) {
            for (int i = 0; i < size.length; i++) {
                //一些逻辑操作（可有可无，视情况而定）
                if (size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1])) {
                    continue;
                }
                //做出选择
                size[i] += nums[index];
                //递归
                backtrack(nums, index - 1, target, size);
                //一些逻辑操作（可有可无，视情况而定）
                //撤销选择
                size[i] -= nums[index];
            }
        }
    }
}