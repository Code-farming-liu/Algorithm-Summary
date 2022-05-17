package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 斐波那契数字定义为：
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 示例 2：
 *
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 示例 3：
 *
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= 10^9
 *
 */
public class Code_1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = getFibs(k);
        int count = 0;
        for (int i = fibs.size() - 1; i >= 0; i--) {
            while (fibs.get(i) <= k && k != 0) {
                k -= fibs.get(i);
                count++;
            }
        }
        return count;
    }

    public List<Integer> getFibs(int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 1) {
            res.add(1);
            return res;
        }
        res.add(1);
        res.add(1);
        int fib = res.get(0) + res.get(1);
        for (int i = 2; fib <= k; i++) {
            fib = res.get(i - 2) + res.get(i - 1);
            res.add(fib);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code_1414().findMinFibonacciNumbers(2));
    }
}
