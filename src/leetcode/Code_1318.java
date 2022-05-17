package leetcode;

/**
 * @ClassName: Code_1318
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/3/19 17:40
 **/

public class Code_1318 {
    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) {
            return 0;
        }
        int res = 0;
        while (a != 0 || b != 0 || c != 0) {
            int i = a & 1;
            int j = b & 1;
            int k = c & 1;
            if ((i | j) == k) {
                if (k == 1) {
                    res++;
                } else {
                    if ((i & j) == 1) {
                        res += 2;
                    } else {
                        res++;
                    }
                }
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return res;
    }
}