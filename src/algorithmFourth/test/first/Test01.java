package algorithmFourth.test.first;

/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/5/1 20:43
 **/

public class Test01 {
    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }

    public static void main(String[] args) {
        System.out.println(mystery(3, 11));
    }
}