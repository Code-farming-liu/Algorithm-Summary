package huawei;

import java.util.*;

/**
 * 题目描述
 * 输入一个数 M ，表示数组中有 M 个数
 * 输入 M 个数。
 * 输入 n
 * 求数组 M 中，去除重复值后，最大 n 个数和最小 n 个数的和
 * 注意：最大和最小的数中不能有重复值，否则输出 -1
 * <p>
 * 样例输入
 * 5
 * 3 3 2 4 2
 * 2
 * 样例输出
 * -1
 * 说明
 * 去除重复后最大的2个数为[4,3]，最小的2个数为[2,3]；有相同值，所以返回-1
 * <p>
 * 样例输入
 * 5
 * 3 3 2 4 2
 * 1
 * 样例输出
 * 6
 * 说明
 * 去除重复后最大的1个数为[4]，最小的1个数为[2]；没有相同值，返回6
 */
public class Code_06 {
    public static void help(int[] nums, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() < 2 * n) {
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += list.get(i) + list.get(list.size() - i - 1);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 4, 2};
        help(nums, 2);
    }
}
