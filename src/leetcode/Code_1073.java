package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Code_1073
 * @Description: 负二进制数相加
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * <p>
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 的数字也同样不含前导零：以 arr 为例，这意味着要么 arr == [0]，要么 arr[0] == 1。
 * <p>
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 * @Author: Admin
 **/

public class Code_1073 {
    /**
     * @param arr1
     * @param arr2
     * @Author: Admin
     * @Description:
     * 这道题是-2进制，所以与2进制有些许不同，进位有可能是-1，0，1，且每次进位都需要调换一下正负号。
     *
     * 因此，加入进位后，运算结果可能为（-1，0，1，2，3）。-1时为0+0+(-1)，3时为1+1+1。
     *
     * 对应的进位符号为 -1，0，1，2，3
     * 1，0，0，-1，-1
     *
     * 这是因为-1时说明前面的进位为负，因此进位为1；2和3时说明前面的进位为正，因此进位为-1。
     * @return: int[]
     */
    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int p1 = arr1.length - 1;
        int p2 = arr2.length - 1;
        int temp = 0;
        int k = Math.max(p1 + 1, p2 + 1) + 1;
        int[] res = new int[k + 1];
        while (p1 >= 0 || p2 >= 0 || temp != 0) {
            int cur = temp;
            if (p1 >= 0) {
                cur += arr1[p1--];
            }
            if (p2 >= 0) {
                cur += arr2[p2--];
            }
            // 当cur = -1时，使用 cur % 2将得到 -1
            // -1的补码 1111111 & 1 还是 1
            res[k--] = cur & 1;
            // 当 cur = -1时， 使用 -cur / 2将得到 0
            // 进位有正有负
            temp = -(cur >> 1);
        }
        int index = 0;
        while (index < res.length - 1 && res[index] == 0) {
            index++;
        }
        return Arrays.copyOfRange(res, index, res.length);
    }

    public int[] addNegabinary1(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int len = Math.max(i + 1, j + 1) + 2;
        int[] res = new int[len];
        int c = 0;
        int k = len - 1;
        while (i >= 0 || j >= 0 || c != 0) {
            if (i >= 0) c += arr1[i];
            if (j >= 0) c += arr2[j];
            res[k--] = Math.abs(c) % 2;
            if (c < 0) c = 1;
            else if (c > 1) c = -1;
            else c = 0;
            i--;
            j--;
        }

        //寻找第一位不为0的数
        int index = 0;
        while (index < len - 1 && res[index] == 0) {
            index++;
        }
        return Arrays.copyOfRange(res, index, len);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 1};
        int[] arr2 = {1, 0, 1};
        addNegabinary(arr1, arr2);
    }
}