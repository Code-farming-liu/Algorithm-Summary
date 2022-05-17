package leetcode;

/**
 * @ClassName: Code_1734
 * @Description: 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * @Author: Admin
 **/

public class Code_1734 {
    /**
     * @Author: Admin
     * @Description: 
     * https://leetcode-cn.com/problems/decode-xored-permutation/solution/gong-shui-san-xie-note-bie-pian-li-yong-zeh6o/
     * @param encoded
     * @return: int[]
     */
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        // 求得除了 res[n - 1] 的所有异或结果
        int a = 0;
        for (int i = 0; i < n - 1; i += 2) {
            a ^= encoded[i];
        }
        // 求得 res 的所有异或结果
        int b = 0;
        for (int i = 1; i <= n; i++) {
            b ^= i;
        }
        // 求得 res[n - 1] 后，从后往前做
        res[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            res[i] = encoded[i] ^ res[i + 1];
        }
        return res;
    }
}