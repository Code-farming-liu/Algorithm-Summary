package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @ClassName: Code_220
 * @Description: 存在重复元素III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 *
 * @Author: Admin
 * @Date 2021/4/17 19:22
 **/

public class Code_220 {
    /**
     * @Author: Admin
     * @Description: 滑动窗口 + 有序集合
     *
     * 根据abs(i - j) <= k 可以得到 每一个元素的左侧至多K个元素，之后我们只需要判断这K个元素是否有
     *
     * 在[x - t, x + t]区间中的元素，如果有那么我们就直接找到了，
     * 对于相邻元素，他们的左侧K个元素有对应的K - 1个元素是重复的，因此呢我们使用对应的滑动窗口，
     * 维护一个k大小长度的滑动窗口，我们还需要将滑动窗口中的元素有序，
     * 这样我们就需要使用到对应的有序集合去实现这个滑动窗口，
     * 我们如果滑动窗口中的元素大于k那么我们直接将对应的滑动窗口的第一个元素移除即可。
     *
     * 注意：
     *
     * 如果当前有序集合中存在相同的元素，那么此时程序直接返回true。
     * 因此我们要使用一个不可重复的有序集合作为滑动窗口的实现，还需要将对应的int改成long 防止溢出异常。
     * @param nums
     * @param k
     * @param t
     * @return: boolean
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            // ceiling 返回此集中最大的元素小于或等于给定元素，如果没有此元素，则 null 。
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long)t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int length = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < length; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    public static long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }



        public static void main(String[] args) {
        int[] nums = {-2147483648,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}