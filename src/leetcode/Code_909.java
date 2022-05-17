package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code_909
 * @Description: 蛇梯棋
 * 始，每一行交替方向。
 *
 * 例如，一块 6 x 6 大小的棋盘，编号如下：
 *
 *
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。
 *
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 *
 * 每一回合，玩家需要从当前方格 x 开始出发，按下述要求前进：
 *
 * 选定目标方格：选择从编号 x+1，x+2，x+3，x+4，x+5，或者 x+6 的方格中选出一个目标方格 s ，目标方格的编号 <= N*N。
 * 该选择模拟了掷骰子的情景，无论棋盘大小如何，你的目的地范围也只能处于区间 [x+1, x+6] 之间。
 * 传送玩家：如果目标方格 S 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 S。 
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 *
 * 返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * 输入：[
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * 输出：4
 * 解释：
 * 首先，从方格 1 [第 5 行，第 0 列] 开始。
 * 你决定移动到方格 2，并必须爬过梯子移动到到方格 15。
 * 然后你决定移动到方格 17 [第 3 行，第 5 列]，必须爬过蛇到方格 13。
 * 然后你决定移动到方格 14，且必须通过梯子移动到方格 35。
 * 然后你决定移动到方格 36, 游戏结束。
 * 可以证明你需要至少 4 次移动才能到达第 N*N 个方格，所以答案是 4。
 *  
 *
 * 提示：
 *
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] 介于 1 和 N*N 之间或者等于 -1。
 * 编号为 1 的方格上没有蛇或梯子。
 * 编号为 N*N 的方格上没有蛇或梯子。
 *
 * @Author: Admin
 **/

public class Code_909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] nums = new int[n * n + 1];
        boolean isRight = true;
        for (int i = n - 1, index = 1; i >= 0; i--) {
            for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[index++] = board[i][j];
            }
            isRight = !isRight;
        }
        Math.round(1.1);
        return bfs(nums, n);
    }

    public int bfs(int[] nums, int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.addLast(1);
        map.put(1, 0);
        while (!queue.isEmpty()) {
            Integer cur = queue.pollFirst();
            int step = map.get(cur);
            if (cur == n * n) {
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int willWork = cur + i;
                if (willWork <= 0 || willWork > n * n) {
                    continue;
                }
                if (nums[willWork] != -1) {
                    willWork = nums[willWork];
                }
                if (map.containsKey(willWork)) {
                    continue;
                }
                map.put(willWork, step + 1);
                queue.addLast(willWork);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "aaabb";
        String str2 = "aaa";
        System.out.println(str1.compareTo(str2));
    }
}