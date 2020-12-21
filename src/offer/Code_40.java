package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test36
 * @Description: 数组中只出现了一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * @Author: Admin
 **/

public class Code_40 {
    /**
     * @param array
     * @param num1
     * @param num2
     * @Author: Admin
     * Description: 思路描述：
     *
     * 我们直接使用map集合辅助遍历，当key存在时，对应的value++，当key不存在时对应的value设置为1，
     * 最后我们遍历map集合 找出这两个只出现了一次的数字即可
     * @return: void
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], 2);
            } else {
                map.put(array[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 0) {
                    num1[0] = array[i];
                    count++;
                } else {
                    num2[0] = array[i];
                }
            }
        }
    }
}