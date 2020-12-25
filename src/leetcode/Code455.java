package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Code455
 * @Description: 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 *  
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 * @Author: Admin
 **/

public class Code455 {
    /**
     * @param g
     * @param s
     * @Author: Admin
     * @Description: 思路描述
     * 使用双指针加贪心，我们将对应的小孩胃口数组排序，饼干数组排序，
     * 用最小的饼干去给最小胃口的小孩子吃，如果不行，那么我们就用稍微大点的饼干再去试试
     * @return: int
     */
    public int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = 0;
        int p2 = 0;
        int res = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                res++;
                p1++;
                p2++;
            } else {
                p2++;
            }
        }
        return res;
    }

    /**
     * @param g
     * @param s
     * @Author: Admin
     * @Description: 思路描述
     * 使用双指针加贪心，我们将对应的小孩胃口数组排序，饼干数组排序，
     * 用最大的饼干给胃口最大的小朋友吃，最大的饼干不行，那就给胃口稍微小点的孩子去试试
     * @return: int
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int p1 = g.length - 1;
        int p2 = s.length - 1;
        int res = 0;
        while (p1 >= 0 && p2 >= 0) {
            if (g[p1] <= s[p2]) {
                res++;
                p1--;
                p2--;
            } else {
                p1--;
            }
        }
        return res;
    }
}