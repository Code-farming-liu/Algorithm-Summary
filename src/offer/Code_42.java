package offer;

import java.util.ArrayList;

/**
 * @ClassName: Test38
 * @Description: 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Author: Admin
 **/

public class Code_42 {
    /**
     * @param array
     * @param sum
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以提取到是一个递增排序的数组，因此我们可以
     * 使用对应的双指针，左指针 left 指向数组开始位置，右指针指向数组结束的位置 ，
     * 如果当前值小于目标值，则left++；
     * 如果当前值大于目标值，则right--；
     * 否则将该值加入到集合当中并返回。
     * @return: java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (sum <= 2) {
            return res;
        }
        int slow = 0;
        int fast = array.length - 1;
        while (slow < fast) {
            int cur = array[slow] + array[fast];
            if (cur == sum) {
                res.add(array[slow]);
                res.add(array[fast]);
                break;
            } else if (cur < sum) {
                slow++;
            } else {
                fast--;
            }
        }
        return res;
    }
}