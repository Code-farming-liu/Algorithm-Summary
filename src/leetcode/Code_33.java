package leetcode;

/**
 * @ClassName: Code_33
 * @Description: 搜索旋转排序数组
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转
 * （例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * @Author: Admin
 * @Date 2021/1/1 9:34
 **/

public class Code_33 {
    /**
     * @param nums
     * @param target
     * @Author: Admin
     * Description: 思路描述
     * 我们可以发现题目中的数组都是有序的，只不过旋转之后我们一定有左半部分有序，右半部分有序，
     *
     * 有序数组中查找一个对应的值，使用二分查找即可。
     * @return: int
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 证明前半部分有序
            if (nums[left] <= nums[mid]) {
                // target 在前半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // target在后半部分
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}