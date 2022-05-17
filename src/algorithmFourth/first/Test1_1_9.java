package algorithmFourth.first;

/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/1 20:42
 **/

public class Test1_1_9 {

    public static String test(int n) {
        String res = "";
        for (int i = n; i > 0; i /= 2) {
            res = (i % 2) + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(test(5));
    }
}