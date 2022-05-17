package zuoshendata.zuoshen4.basic.class06;

/**
 * @ClassName: 布隆过滤器
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/17 13:17
 **/

public class 布隆过滤器 {

    public static void main(String[] args) {
        // 32000
        int[] arr = new int[1000];

        int index = 30000;

        int intIndex = index / 32;

        int bitIndex = index % 32;

        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));


    }
}