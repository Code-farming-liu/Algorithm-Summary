package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Code_42
 * @Description: 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * @Author: Admin
 * @Date 2021/1/4 19:46
 **/

public class Code_42 {
    // 暴力破解

    /**
     * @param height
     * @Author: Admin
     * @Description: 思路描述：
     * 方法 1：暴力
     * 直观想法
     * <p>
     * 直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * <p>
     * 算法
     * <p>
     * * 初始化一个结果 res = 0;
     * * 从左到右扫描数组
     * * 初始化为 max_left = 0 和 max_right = 0;
     * * 从当前元素向左扫描并更新
     * * max_left = Math.max(max_left, height[j]);
     * * 从当前元素向右扫描并更新
     * * max_right = Math.max(max_right, height[j]);
     * * 将min(max_left, max_right) - height[i], 累加到结果中
     * @return: int
     */
    public static int trap1(int[] height) {
        int length = height.length;
        if (height == null || length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < length - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for (int j = i; j < length; j++) {
                right = Math.max(right, height[j]);
            }
            res += Math.min(left, right) - height[i];
        }
        return res;
    }

    /**
     * @param height
     * @Author: Admin
     * @Description: 思路描述：
     * 在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。但是我们可以提前存储这个值。
     * 找到数组中从下标 i 到最左端最高的条形块高度 left_max。
     * 找到数组中从下标 i 到最右端最高的条形块高度 right_max。
     * 扫描数组 height 并更新答案：
     * 累加 min(max\_left[i],max\_right[i]) - height[i]到ans上
     * @return: int
     */
    public static int trap(int[] height) {
        int length = height.length;
        if (height == null || length == 0) {
            return 0;
        }
        int res = 0;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = height[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    /**
     * @param height
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以不用像方法 2 那样存储最大高度，而是用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。
     * <p>
     * 我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，
     * 我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
     * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，
     * 因此我们可以弹出栈顶元素并且累加答案到 ans 。
     * <p>
     * 算法
     * <p>
     * * 使用栈来存储条形快的索引下标
     * * 遍历数组
     * * 当栈非空且 height[cur] > height[st.top()]
     * * 意味着栈中的元素可以被弹出。弹出栈顶的元素top
     * * 计算当前元素和栈顶元素的距离，准备进行填充操作
     * * distance = cur - st.top() - 1
     * * 找出界定高度
     * * bounded_height = min(height[cur], height[st.top]) - height[top]
     * * 往答案中累加水量 ans += distance * bounded_height
     * * 将当前的索引下表入栈
     * * 将cur移动到下一个位置
     * @return: int
     */
    public static int trap2(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;
    }

    /**
     * @param height
     * @Author: Admin
     * @Description: 思路描述：
     * 双指针
     * 从动态编程方法的示意图中我们注意到，只要 right_max[i]>left_max[i] （元素 0 到元素 6），积水高度将由 left_max 决定，类似地left_max[i]>right_max[i]（元素 8 到元素 11）。
     * 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
     * 我们必须在遍历时维护left_max 和right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。额算法
     * <p>
     * 算法
     * <p>
     * * 初始化 left 指针为 0 并且 right 指针为 size-1
     * * While left<right,
     * * If height[left] < height[right]
     * * If height[left]≥left_max, 更新 left_max
     * * Else 累加left_max−height[left] 到 ans
     * * left = left + 1.
     * * else
     * * if height[right] >= right_max,更新right_max
     * * else累加到 right_max - height[right]到 ans
     * * right = right + 1
     * @return: int
     */
    public int trap3(int[] height) {
        int length = height.length;
        int res = 0;
        int leftMax = 0, rightMax = 0, left = 0, right = length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] res = new int[]{4,2,0,3,2,5};
        trap2(res);
    }
}