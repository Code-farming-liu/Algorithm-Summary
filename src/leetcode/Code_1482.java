package leetcode;

/**
 * @ClassName: Code_1482
 * @Description: 制作m束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * <p>
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * <p>
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * <p>
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
 * 输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * 示例 2：
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
 * 输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * 示例 3：
 * <p>
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * 输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * 示例 4：
 * <p>
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
 * 输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * 示例 5：
 * <p>
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 * @Author: Admin
 **/

public class Code_1482 {
    int n, m, k;
    boolean[] fl;

    public int minDays(int[] nums, int _m, int _k) {
        n = nums.length;
        m = _m;
        k = _k;

        if (n < m * k) {
            return -1;
        }

        fl = new boolean[n];
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            r = Math.max(num, r);
        }

        int l = 0;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return check(nums, r) ? r : -1;
    }

    boolean check(int[] nums, int mid) {
        for (int i = 0; i < n; i++) {
            fl[i] = nums[i] <= mid;
        }
        int cnt = 0;
        for (int i = 0; i < n && cnt < m; ) {
            if (fl[i]) {
                int cur = 1, j = i;
                while (cur < k && j + 1 < n && fl[j + 1]) {
                    j++;
                    cur++;
                }
                if (cur == k) {
                    cnt++;
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 10, 2};
        new Code_1482().minDays(nums, 3, 1);
    }
}