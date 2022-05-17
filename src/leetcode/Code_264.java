package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
//丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
// 
//
//示例 1：
//
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
//示例 2：
//
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
//提示：
//
//1 <= n <= 1690
//
public class Code_264 {
    public int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = queue.poll();
            if (i == n) {
                return (int) x;
            }
            for (int num : nums) {
                long t = num * x;
                if (!set.contains(t)) {
                    queue.add(t);
                    set.add(t);
                }
            }
        }
        return -1;
    }
}
