package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Test98
 * Description: 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * @Author: Admin
 **/

public class Code_287 {

    /**
     * @param nums
     * @Author: Admin
     * @Description: 对数组进行排序，然后遍历数组，判断 前后两个数是否相同。
     * @return: int
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i - 1];
            }
        }
        return -1;
    }

    /**
     * @param nums
     * @Author: Admin
     * @Description: 利用set集合辅助，如果不存在加入集合，存在则直接返回该数。
     * @return: int
     */
    public int findDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    //    二分查找
//    我们知道二分查找要求有序，但是给定的数组不是有序的，那么怎么用二分查找呢？
//
//    原数组不是有序，但是我们知道重复的那个数字肯定是 1 到 n 中的某一个，而 1,2...,n 就是一个有序序列。因此我们可以对 1,2...,n 进行二分查找。
//
//    mid = (1 + n) / 2，接下来判断最终答案是在 [1, mid] 中还是在 [mid + 1, n] 中。
//
//    我们只需要统计原数组中小于等于 mid 的个数，记为 count。
//
//    如果 count > mid ，鸽巢原理，在 [1,mid] 范围内的数字个数超过了 mid ，所以一定有一个重复数字。
//
//    否则的话，既然不在 [1,mid] ，那么最终答案一定在 [mid + 1, n] 中。
    public int findDuplicate4(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    //二进制
    //主要就是我们要把数字放眼到二进制。
    //
    //然后依次统计数组中每一位 1 的个数，记为 a[i]。再依次统计 1 到 n 中每一位 1 的个数，
    // 记为 b[i]。i 代表的是哪一位，因为是 int，所以范围是 0 到 32。
    //
    //记重复的数字是 res。
    //
    //如果 a[i] > b[i] 也就意味着 res 当前位是 1。
    //
    //否则的话，res 当前位就是 0。
    //
    //举个例子吧，1 3 4 2 2。
    //
    //1 3 4 2 2 写成 2 进制
    //1 [0 0 1]
    //3 [0 1 1]
    //4 [1 0 0]
    //2 [0 1 0]
    //2 [0 1 0]
    //
    //把 1 到 n,也就是 1 2 3 4 也写成 2 进制
    //1 [0 0 1]
    //2 [0 1 0]
    //3 [0 1 1]
    //4 [1 0 0]
    //
    //依次统计每一列 1 的个数, res = XXX
    //
    //原数组最后一列 1 的个数是 2
    //1 到 4 最后一列 1 的个数是 2
    //2 不大于 2,所以当前位是 0, res = XX0
    //
    //原数组倒数第二列 1 的个数是 3
    //1 到 4 倒数第二列 1 的个数是 2
    //3 大于 2,所以当前位是 1, res = X10
    //
    //原数组倒数第三列 1 的个数是 1
    //1 到 4 倒数第三列 1 的个数是 1
    //1 不大于 1,所以当前位是 0, res = 010
    //
    //所以 res = 010, 也就是 2
    //
    //上边是重复数字的重复次数是 2 的情况，如果重复次数大于 2 的话上边的结论依旧成立。
    //
    //简单的想一下，1 3 4 2 2 ，因为 2 的倒数第二位的二进制位是 1，所以原数组在倒数第二列中 1 的个数会比1 到 4 这个序列倒数第二列中 1 的个数多 1 个。如果原数组其他的数变成了 2 呢？也就2 的重复次数大于 2。
    //
    //如果是 1 变成了 2，数组变成 2 3 4 2 2 ， 那么倒数第二列中 1 的个数又会增加 1。
    //
    //如果是 3 变成了 2，数组变成 1 2 4 2 2 ， 那么倒数第二列中 1 的个数不会变化。
    //
    //所以不管怎么样，如果重复数字的某一列是 1，那么当前列 1 的个数一定会比 1 到 n 序列中 1 的个数多。
    //
    public int findDuplicate(int[] nums) {
        int res = 0;
        int n = nums.length;
        //统计每一列 1 的个数
        for (int i = 0; i < 32; i++) {
            int a = 0;
            int b = 0;
            int mask = (1 << i);
            for (int j = 0; j < n; j++) {
                //统计原数组当前列 1 的个数
                if ((nums[j] & mask) > 0) {
                    a++;
                }
                //统计 1 到 n 序列中当前列 1 的个数
                if ((j & mask) > 0) {
                    b++;
                }
            }
            if (a > b) {
                res = res | mask;
            }
        }
        return res;
    }

    // ????
    public int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        //寻找相遇点
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //slow 从起点出发, fast 从相遇点出发, 一次走一步
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}