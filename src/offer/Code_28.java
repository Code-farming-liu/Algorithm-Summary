package offer;

import java.util.Arrays;

/**
 * @ClassName: Test26
 * @Description: 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author: Admin
 **/

public class Code_28 {
    /**
     * @param array
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以从题目中提取到 次数超过一半
     * 因此我们可以对原来的数组排序 取中间值，
     * 因为满足超过一半 中间值肯定为这个数字，
     * 因此我们只需要统计该值是不是大于数组的一半即可
     * 如果大于 则返回该值
     * 否则 返回 0
     * @return: int
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int num : array) {
            if (num == array[array.length / 2]) {
                count++;
            }
        }
        return count > array.length / 2 ? array[array.length / 2] : 0;
    }
}