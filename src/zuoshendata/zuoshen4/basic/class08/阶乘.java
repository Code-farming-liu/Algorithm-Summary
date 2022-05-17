package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 阶乘
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/8 18:02
 **/

public class 阶乘 {
    public static long test(int n) {
        if (n == 1) {
            return 1L;
        }
        return (long)n * test(n - 1);
    }
}