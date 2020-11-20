import java.util.Arrays;

/**
 * @ClassName: Test86
 * Description:乘积最大的序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * @Author: Admin
 **/

public class Test84 {
    public static int maxProduct1(int[] nums) {
        int[] num = new int[nums.length];
        System.arraycopy(nums,0,num,0,nums.length);
        Arrays.sort(num);
        int result = 0;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            result = Math.max(nums[0],nums[1]);
            result = Math.max(result,(nums[0] * nums[1]));
            return result;
        }
        int a = 0;
        result = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            a = i + 1;
            int b = nums[i];
            while(a < nums.length ) {
                b *= nums[a];
                result = Math.max(b, result);
                a++;
            }
        }
        for(int i = 1; i < nums.length;i++){
            result = Math.max(result,(nums[i] * nums[i - 1]));
        }
        result = Math.max(result,num[num.length - 1]);
        return result;
    }
    // 遍历数组时计算当前最大值，不断更新
    // 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
    // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。
    // 因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    // 当负数出现时则imax与imin进行交换再进行下一步计算
    // 时间复杂度：O(n)
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
}