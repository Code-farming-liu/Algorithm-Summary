import java.util.HashMap;

/**
 * @ClassName: Test59
 * @Description: 有效的数独
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @Author: Admin
 **/

public class Test59 {
    public boolean isValidSudoku2(char[][] board) {
        //初始化
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // 分区域遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num;
                    int box_index = (i / 3) * 3 + j / 3;

                    // 记录当前值出现的次数
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // 检查当前值是否已经出现过了
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public boolean isValidSudoku3(char[][] board) {
        int[][] row = new int[9][9];//row
        int[][] col = new int[9][9];//colomn
        int[][] box = new int[9][9];//9-digit cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //取出当前的值
                int x = board[i][j] - '0';
                //判断该值是否是 1 - 9
                if (x >= 1 && x <= 9) {
                    //记录当前数字出现次数
                    // 因为是数组下标从0开始 因此 x - 1
                    row[i][x - 1]++;
                    col[j][x - 1]++;
                    //i / 3 * 3 + j / 3
                    // 这个我们可以画图理解 将对应的 9 * 9 划分成 9 个 3 * 3 对应的各自区域
                    box[i / 3 * 3 + j / 3][x - 1]++;
                    //判断当前值是否已经出现过
                    if (row[i][x - 1] > 1 || col[j][x - 1] > 1 || box[i / 3 * 3 + j / 3][x - 1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}