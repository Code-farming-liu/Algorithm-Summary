package huawei;

import java.util.*;

/**
 * 【编程 | 100分】组成最大数
 * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 *
 * 输入描述:
 * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人
 *
 * 输出描述:
 * 最大的数字字符串
 *
 * 示例1
 *
 * 输入
 *
 * 1
 * 22,221
 * 输出
 *
 * 1
 * 22221
 * 示例2
 *
 * 输入
 *
 * 1
 * 4589,101,41425,9999
 * 输出
 *
 * 1
 * 9999458941425101
 */
public class Code05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        for (String s : split) {
            list.add(s);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
