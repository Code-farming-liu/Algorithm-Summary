package leetcode;

/**
 * @ClassName: Code_1095
 * @Description: 山脉数组中查找目标值
 * （这是一个 交互式问题 ）
 * <p>
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * <p>
 * 如果不存在这样的下标 index，就请返回 -1。
 * <p>
 *  
 * <p>
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * <p>
 * 首先，A.length >= 3
 * <p>
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * <p>
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *  
 * <p>
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * <p>
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *  
 * <p>
 * 注意：
 * <p>
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 * <p>
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 * <p>
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 * @Author: Admin
 **/

public class Code_1095 {
    // 特别注意：3 个辅助方法的分支出奇地一样，因此选中位数均选左中位数，才不会发生死循环

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        // 步骤 1：先找到山顶元素所在的索引
        int mountaintop = findMountaintop(mountainArr, 0, size - 1);
        // 步骤 2：在前有序且升序数组中找 target 所在的索引
        int res = findFromSortedArr(mountainArr, 0, mountaintop, target);
        if (res != -1) {
            return res;
        }
        // 步骤 3：如果步骤 2 找不到，就在后有序且降序数组中找 target 所在的索引
        return findFromInversedArr(mountainArr, mountaintop + 1, size - 1, target);
    }

    private int findMountaintop(MountainArray mountainArr, int l, int r) {
        // 返回山顶元素
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 取左中位数，因为进入循环，数组一定至少有 2 个元素
            // 因此，左中位数一定有右边元素，数组下标不会发生越界
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 如果当前的数比右边的数小，它一定不是山顶
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 根据题意，山顶元素一定存在，因此退出 while 循环的时候，不用再单独作判断
        return l;
    }

    private int findFromSortedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在前有序且升序数组中找 target 所在的索引
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }

    private int findFromInversedArr(MountainArray mountainArr, int l, int r, int target) {
        // 在后有序且降序数组中找 target 所在的索引
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 与 findFromSortedArr 方法不同的地方仅仅在于由原来的小于号改成大于好
            if (mountainArr.get(mid) > target) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        // 因为不确定区间收缩成 1个数以后，这个数是不是要找的数，因此单独做一次判断
        if (mountainArr.get(l) == target) {
            return l;
        }
        return -1;
    }
}

class MountainArray {
    public int get(int index) {
        return 0;
    }

    public int length() {
        return 0;
    }
}