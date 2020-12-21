package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test13
 * @Description: 调整数组的顺序使奇数位于偶数的前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author: Admin
 **/

public class Code_13 {
    /**
     * @Author: Admin
     * @Description: 思路描述：
     * 思路描述：
     * 使用两个集合辅助，
     * 将原数组的偶数放入list1
     * 将奇数放入list2
     * 将对应的集合合并，在写入对应的数组中。
     * @param array
     * @return: void
     */
    public void reOrderArray(int[] array) {
        List<Integer> list1 = new ArrayList<>(array.length);
        List<Integer> list2 = new ArrayList<>(array.length);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        list1.addAll(list2);
        for (int i = 0; i < array.length; i++) {
            array[i] = list1.get(i);
        }
    }
}