import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Code_989
 * @Description: 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * @Author: Admin
 **/

public class Code_989 {
    /**
     * @param A
     * @param K
     * @Author: Admin
     * @Description: 思路描述：
     * 像是低位加法运算，每次相加超过10，我们就进位，最后将结果反转即可。
     * @return: java.util.List<java.lang.Integer>
     */
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * @param A
     * @param K
     * @Author: Admin
     * @Description: 思路描述：
     * 下面思路一致，我们将K作为数组的低位
     * <p>
     * 上面的例子 123+912，我们把它表示成 [ 1,2,3+912 ] 。然后，我们计算 3+912=915。5 留在当前这一位，将 910/10=91 以进位的形式加入下一位。
     * <p>
     * 然后，我们再重复这个过程，计算 [1,2+91,5] 。我们得到 93，3 留在当前位，将 90/10=9 以进位的形式加入下一位。继而又得到 [1+9,3,5]，重复这个过程之后，最终得到结果 [1,0,3,5]。
     * @return: java.util.List<java.lang.Integer>
     */
    public static List<Integer> addToArrayForm1(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}