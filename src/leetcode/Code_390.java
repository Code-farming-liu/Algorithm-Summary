package leetcode;

/**
 * 消除游戏
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/elimination-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_390 {
    /**
     * https://leetcode.cn/problems/elimination-game/solution/gong-shui-san-xie-yue-se-fu-huan-yun-yon-x60m/
     * 同样想到了约瑟夫环，关于
     * 1. a[i]+b[i]=i+1，
     * 可以这样想的：对于某个序列来说，「从右到左，间隔删除」等价于「将序列逆序，从左到右，间隔删除」，如序列[1,n]，n=6
     * <p>
     * a[]: 1 2 3 4 5 6
     * b[]: 6 5 4 3 2 1
     * 对于任意合法的i，满足 a[i] +b[i] = 7 = 1 + n，因此间隔删除后，剩下的那一组 a[i] b[i]，它们的和也是7.
     * 其实，对于无论是「从右到左」还是「从左到右」，只要删除具有对称性，上述公式还是成立的。
     * <p>
     * 2. a[i] = b[i / 2] * 2
     * a[]: 从左往右间隔删除 剩余 2 4 6
     * 重新编码
     * 也就是 2 4 6 ===> 1 2 3
     * 反映射 原来的  1 2 3 分别 * 2  = 2 4 6
     * <p>
     * 之后 1 2 带入 消除b[i]
     * a[i] = 2 * (i / 2) + 1 - a[i / 2]
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}