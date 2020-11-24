/**
 * @ClassName: Test96
 * Description: 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，
 * 返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * @Author: Admin
 **/

public class Test96 {
    public int[] productExceptSelf1(int[] nums) {
        //数组的长度
        int length = nums.length;

        //初始化左右两个数组 L[i] 为 i左边所有元素的乘积 R[i] i右边的所有元素的乘积
        int[] L = new int[length];
        int[] R = new int[length];

        //最终的结果数组
        int[] answer = new int[length];
        //左边数组的第一个数 因为是第一个数 肯定没有元素 因为后面需要使用乘积设置为1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        //右边数组的最后一个数 因为是最后一个数 肯定没有元素 因为后面需要使用乘积设置为1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        //左边对应的结果 * 右边对应的结果 最后则为最终的结果
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}