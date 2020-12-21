package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Test27
 * @Description: 最小的K个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @Author: Admin
 **/

public class Code_29 {
    /**
     * @param input
     * @param k
     * @Author: Admin
     * @Description: 思路描述：
     *
     * 将原数组排序，然后从开始遍历到K即可
     * @return: java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}