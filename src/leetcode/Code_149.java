package leetcode;

/**
 * @ClassName: Code_149
 * @Description: 直线上最多的点数
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * 示例 2：
 * <p>
 * <p>
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * points 中的所有点 互不相同
 * @Author: Admin
 **/

public class Code_149 {
    public int maxPoints(int[][] ps) {
        int m = ps.length;
        int n = ps[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}