package algorithmFourth.first;

/**
 * @ClassName: Test1_1_13
 * @Description: 转置矩阵
 * @Author: Admin
 * @Date 2021/5/1 21:22
 **/

public class Test1_1_24 {
    public static int test(int a, int b) {
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return test(b, r);
    }

    public static void main(String[] args) {
        System.out.println(test(105, 24   ));
    }
}