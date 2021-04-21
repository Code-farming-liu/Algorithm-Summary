package leetcode;

import java.util.Stack;

/**
 * @ClassName: Code_739
 * @Description: 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @Author: Admin
 **/

public class Code_739 {
    // 暴力破解
    public static int[] dailyTemperatures1(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        if (length == 0) {
            return res;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * @Author: Admin
     * @Description:
     * 判别是否需要使用单调栈，如果需要找到左边或者右边第一个比当前位置的数大或者小，则可以考虑使用单调栈；
     *
     * 单调栈，我们使用一个栈记录元素的下标，
     *
     * 1. 栈为空直接添加进入栈
     * 2. 当前元素大于栈顶的元素，证明找到了升温日期，则将对应的栈顶弹出，并记录即可。
     * @param nums
     * @return: int[]
     */
    public static int[] dailyTemperatures(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Stack<Integer> stack = new Stack<>();
        if (length == 0) {
            return res;
        }
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }
}