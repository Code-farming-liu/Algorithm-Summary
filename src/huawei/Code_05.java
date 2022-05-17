package huawei;

/**
 * 给定一个正整数数组，最大为100个成员，从第一个成员开始，走到数组最后一个成员最少的步骤数。
 * 第一步必须从第一元素开始，1<=步长<len/2, 第二步开始以所在成员的数字走相应的步数，如果目标不可达返回-1，只输出最少的步骤数。
 * 7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9
 * 2
 * 第一个可选步长选择2，第一个成员7走第2个成员，第二步，第2个成员为9，经过9个成员到最后
 */
public class Code_05 {
    public static void findFinal(int[] nums) {
        int min = 100;
        for (int i = 1; i < nums.length / 2; i++) {
            int res = 0;
            for (int j = i; j < nums.length; j += nums[i]) {
                res++;
                if (j == nums.length - 1) {
                    min = Math.min(min, res);
                    break;
                }
            }
        }
        System.out.println(min == 100 ? -1 : min);
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 9, 4, 2, 6, 8, 3, 5, 4, 3, 9};
        findFinal(nums);
    }
}
