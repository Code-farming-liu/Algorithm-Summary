package zuoshendata.class01;

/**
 * @ClassName: 奇数次和偶数次
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/7 18:46
 **/

public class 奇数次和偶数次 {

    //arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int res = 0;
        for (int num : arr) {
            res ^= num;
        }
        System.out.println(res);
    }

    //arr 中有两种数，出现奇数次
    public void printOddTimesNum2(int[] arr) {
        int res1 = 0;
        for (int num : arr) {
            res1 ^= num;
        }
        // res1 = a ^ b
        // res1 != 0;
        // res1 某个位置上必定是1
        //提取中最右侧的一
        int rightOne = res1 & ((~res1) + 1);
        int res2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                res2 ^= arr[i];
            }
        }
        System.out.println(res2 + " " + (res1 ^ res2));
    }

    //统计一个二进制中1的个数
    public static int bit1counts(int num) {
        int count = 0;
        // 001100
        // 000100   count = 1
        // 001000

        // 0010000
        // 0010000  count = 2
        // 0000000

        while (num != 0) {
            int rightOne = num & ((~num) + 1);
            count++;
            num ^= rightOne;
        }
        return count;
    }
}