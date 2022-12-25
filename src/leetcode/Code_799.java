package leetcode;

/**
 * 第K个语法符号
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 */
public class Code_799 {
    // 后半部分是前半部分的反转
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int r = kthGrammar(n - 1, (k + 1) / 2);
        return r == 0 ? 1 - (k % 2) : k % 2;
    }

    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        new Code_799().kthGrammar(1, 1);
    }
}
