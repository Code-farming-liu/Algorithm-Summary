package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Test25
 * @Description: 二叉搜索树与双向链表
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @Author: Admin
 **/

public class Code_26 {
    /**
     * @param str
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以看例子
     * a b c 可以组成的 所有组合
     * 确定首部为 a -------- a b c 、a c b
     * 确定首部为b --------- b a c 、b c a
     * 确定首部为c ----------c a b 、c b a
     * 我们不难看出 其实就是确定首部 然后交换剩余部分即可，
     * 题目需要字典序，我们可以使用 Collections.sort(list); 默认按照字典序
     * @return: java.util.ArrayList<java.lang.String>
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            help(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;

    }

    //一个辅助函数辅助递归遍历 交换
    public void help(char[] chars, int i, ArrayList<String> list) {
        //证明遍历完毕
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !set.contains(chars[j])) {
                    set.add(chars[j]);
                    swap(chars, i, j);
                    help(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }

    //进行交换
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}