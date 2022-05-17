package leetcode;

/**
 * @ClassName: Code_1300
 * @Description: 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 *
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 *
 * 请注意，答案不一定是 arr 中的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 *
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 *
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 *
 * @Author: Admin
 **/

public class Code_1300 {
    public int findBestValue(int[] arr, int target) {
        int left = 0;
        int right = 0;
        // 注意：
        for (int num : arr) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);
            // 计算第 1 个使得转变后数组的和大于等于 target 的阈值 threshold
            if (sum < target) {
                // 严格小于的一定不是解
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 比较阈值线分别定在 left - 1 和 left 的时候与 target 的接近程度
        int sum1 = calculateSum(arr, left - 1);
        int sum2 = calculateSum(arr, left);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    private int calculateSum(int[] arr, int threshold) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, threshold);
        }
        return sum;
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/solution/er-fen-cha-zhao-by-liweiwei1419-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        new Code_1300().findBestValue(arr, 10);
    }
}