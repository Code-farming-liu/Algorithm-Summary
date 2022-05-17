package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 *输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 */
public class Code_57_2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
