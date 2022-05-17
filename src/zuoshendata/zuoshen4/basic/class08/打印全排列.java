package zuoshendata.zuoshen4.basic.class08;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 打印全排列
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/8 21:57
 **/

public class 打印全排列 {
    public static void pringAll(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int a = i; a < str.length; a++) {
            if (!set.contains(str[i])) {
                set.add(str[a]);
                swap(str, i, a);
                pringAll(str, i + 1);
            }
        }
    }
    public static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process2(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String test = "abc";
//        pringAll(test.toCharArray(), 0);
        process2(test.toCharArray(), 0);
    }
}