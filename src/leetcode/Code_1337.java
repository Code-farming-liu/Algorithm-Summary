package leetcode;

import java.util.PriorityQueue;

// 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
//
//请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
//
//如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
//
//军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
//
// 
//
//示例 1：
//
//输入：mat =
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]],
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2
//行 1 -> 4
//行 2 -> 1
//行 3 -> 2
//行 4 -> 5
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
//示例 2：
//
//输入：mat =
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]],
//k = 2
//输出：[0,2]
//解释：
//每行中的军人数目：
//行 0 -> 1
//行 1 -> 4
//行 2 -> 1
//行 3 -> 1
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
//提示：
//
//m == mat.length
//n == mat[i].length
//2 <= n, m <= 100
//1 <= k <= m
//matrix[i][j] 不是 0 就是 1
//
public class Code_1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<C> queue = new PriorityQueue<>(((o1, o2) -> o1.count == o2.count ? o2.row - o1.row : o2.count - o1.count));
        for (int i = 0; i < mat.length; i++) {
            C c = new C();
            int left = 0, right = mat[0].length - 1, pos = -1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (mat[i][mid] == 0) {
                    right = mid - 1;
                } else {
                    pos = mid;
                    left = mid + 1;
                }
            }
            c.count = pos + 1;
            c.row = i;
            queue.offer(c);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] nums = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            nums[i] = queue.poll().row;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        new Code_1337().kWeakestRows(mat, 3);
    }
}

class C {
    int count;
    int row;
}
