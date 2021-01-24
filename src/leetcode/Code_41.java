package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Code_41
 * @Description: 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * <p>
 * <p>
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * @Author: Admin
 **/

public class Code_41 {

    /**
     * @param nums
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以使用HashSet集合辅助遍历，第一遍遍历将数组中的值加入到set集合之中，第二次遍历从1开始遍历，判断那个值不在集合之中，返回即可。
     * @return: int
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len; i++) {
            if (!hashSet.contains(i)) {
                return i;
            }
        }
        return len + 1;
    }


    /**
     * @param nums
     * @Author: Admin
     * @Description: 思路描述：
     * 我们还可以把每个元素存放到对应的位置，比如1存放到数组的第一个位置，3存放到数组的第3个位置，
     * 如果是非正数或者大于数组的长度的值，我们不做处理，最后在遍历一遍数组，如果位置不正确，说明这个位置没有这个数，我们就直接返回
     * @return: int
     */
    public int firstMissingPositive1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //如果在指定的位置就不需要修改
            if (i + 1 == nums[i]) {
                continue;
            }
            int x = nums[i];
            if (x >= 1 && x <= nums.length && x != nums[x - 1]) {
                swap(nums, i, x - 1);
                i--;//抵消上面的i++，如果交换之后就不++；
            }
        }
        //最后在执行一遍循环，查看对应位置的元素是否正确，如果不正确直接返回
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    //交换两个数的值
    public void swap(int[] A, int i, int j) {
        if (i != j) {
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }
}