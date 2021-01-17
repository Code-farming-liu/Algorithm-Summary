package leetcode;

/**
 * @ClassName: Code_1232
 * @Description: 缀点成线
 * <p>
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * @Author: Admin
 **/

public class Code_1232 {
    /**
     * @param coordinates
     * @Author: Admin
     * @Description: 思路描述
     * 我们首先选择一个基准点，求出某个点与基准点的 斜率 也就是 k1 = x1 / y1
     *
     * 后续各点之间之间都与脊椎点求斜率，即为 ki = xi / yi
     *
     * 判断斜率是否相等即可。
     * @return: boolean
     */
    public boolean checkStraightLine(int[][] coordinates) {
        // 基准点
        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            int x2 = coordinates[i][0] - coordinates[0][0];
            int y2 = coordinates[i][1] - coordinates[0][1];
            if (x1 * y2 != x2 * y1) {
                return false;
            }
        }
        return true;
    }
}