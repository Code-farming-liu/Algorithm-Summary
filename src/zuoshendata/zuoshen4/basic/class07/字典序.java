package zuoshendata.zuoshen4.basic.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: 字典序
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 10:35
 **/

public class 字典序 {

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return (str1).compareTo(str2);
            }
        });
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}