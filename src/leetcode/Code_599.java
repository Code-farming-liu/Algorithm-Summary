package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Code_599
 * @Description: 两个列表的最小索引总和
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 提示:
 * <p>
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * @Author: Admin
 * @Date 2021/9/25 10:03
 **/

public class Code_599 {
//    public String[] findRestaurant(String[] list1, String[] list2) {
//        // key: 相同字符串的索引和
//        // value: 这个相同索引和 有多少个字符串
//        Map<Integer, List<String>> map = new HashMap<>();
//        for (int i = 0; i < list1.length; i++) {
//            for (int j = 0; j < list2.length; j++) {
//                if (list1[i].equals(list2[j])) {
//                    // map中是否包含这个索引和
//                    if (!map.containsKey(i + j)) {
//                        map.put(i + j, new ArrayList<>());
//                    }
//                    // map包含在原有集合添加
//                    map.get(i + j).add(list1[i]);
//                }
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        // 遍历索引和 找到最小的返回
//        for (int key : map.keySet()) {
//            min = Math.min(min, key);
//        }
//        String[] res = new String[map.get(min).size()];
//        return map.get(min).toArray(res);
//    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                Integer first = map.get(list2[i]);
                if (first + i < temp) {
                    temp = first + i;
                    res.clear();
                    res.add(list2[i]);
                } else if (first + i == temp) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }

    public static void main(String[] args) {
        String[] str1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] str2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = findRestaurant(str1, str2);
        System.out.println(restaurant);
    }
}