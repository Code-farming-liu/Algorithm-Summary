package huawei;

/**
 * 题目描述：
 *
 * 有N个正整数组成的一个序列，给定一个整数sum
 * 求长度最长的的连续子序列使他们的和等于sum
 * 返回次子序列的长度，如果没有满足要求的序列 返回-1
 * 备注：
 *
 * 输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分割
 * 序列长度 1<=N<=200，输入序列不考虑异常情况
 * 由题目保证输入序列满足要求
 * 示例
 *
 * 输入：
 *
 * 1,2,3,4,2
 * 6
 * 输出：
 *
 * 3
 * 解析：
 *
 * 1,2,3和4,2两个序列均能满足要求，所以最长的连续序列为1,2,3 因此结果为3
 * 输入：
 *
 * 1,2,3,4,2
 * 20
 * 输出：
 *
 * -1
 * 解释：
 *
 */
public class Code01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2};
        new Code01().getMaxLen(nums, 6);
    }

    public void getMaxLen(int[] nums, int sum) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            temp += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp > sum) {
                    break;
                }
                if (temp == sum) {
                    res = Math.max(res, j - i + 1);
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
