package leetcode;

import java.util.*;

/**
 * @ClassName: Code_815
 * @Description: 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 * <p>
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 * @Author: Admin
 **/

public class Code_815 {
    int s, t;
    int[][] rs;

    public int numBusesToDestination(int[][] routes, int source, int target) {
        rs = routes;
        s = source;
        t = target;
        if (s == t) {
            return 0;
        }
        int ans = bfs();
        return ans;
    }

    public int bfs() {
        // 记录某个车站可以进入的路线
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 队列存的是经过的路线
        Deque<Integer> queue = new ArrayDeque<>();
        // 哈希表记录的进入该路线所使用的距离
        Map<Integer, Integer> m = new HashMap<>();
        int n = rs.length;
        for (int i = 0; i < n; i++) {
            for (int station : rs[i]) {
                // 将从起点可以进入的路线加入队列
                if (station == s) {
                    queue.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!queue.isEmpty()) {
            // 取出当前所在的路线，与进入该路线所花费的距离
            int poll = queue.pollFirst();
            int step = m.get(poll);

            // 遍历该路线所包含的车站
            for (int station : rs[poll]) {
                // 如果包含终点，返回进入该路线花费的距离即可
                if (station == t) {
                    return step;
                }
                // 将由该线路的车站发起的路线，加入队列
                Set<Integer> lines = map.get(station);
                if (lines == null) {
                    continue;
                }
                for (int nr : lines) {
                    if (!m.containsKey(nr)) {
                        m.put(nr, step + 1);
                        queue.add(nr);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code_815 code_815 = new Code_815();
        int[][] nums = {
                {1, 2, 7},
                {3, 6, 7}
        };
        code_815.numBusesToDestination(nums, 1, 6);
    }
}