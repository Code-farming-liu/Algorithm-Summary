package offer;

import java.util.Arrays;

/**
 * @ClassName: Code_32
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/17 16:08
 **/

public class Code_32 {
    public String PrintMinNumber(int [] numbers) {
        Arrays.sort(numbers);
        StringBuilder res = new StringBuilder();
        for (int number : numbers) {
            res.append(number);
        }
        return res.toString();
    }
}