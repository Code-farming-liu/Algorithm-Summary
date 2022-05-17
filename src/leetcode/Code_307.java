package leetcode;

/**
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 pdate 和 sumRange 方法次数不大于 3 * 104 
 */
public class Code_307 {
    int[] nums = null;
    TreeArray treeArray = null;
    public Code_307(int[] nums) {
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
        treeArray = new TreeArray(nums);
    }

    public void update(int index, int val) {
        treeArray.update(index, val);
    }

    public int sumRange(int left, int right) {
        return treeArray.sumRange(left, right);
    }
}

class TreeArray {
    // 上来先把三个方法写出来
    int[] tree;
    int[] nums;
    public TreeArray(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public int lowbit(int x) {
        return x & -x;
    }

    // 查询前缀和的方法
    public int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            ans += tree[i];
        }
        return ans;
    }

    // 在树状数组 x 位置中增加值 u
    void add(int x, int u) {
        for (int i = x; i <= nums.length; i += lowbit(i)) {
            tree[i] += u;
        }
    }
    // 使用【树状数组】
    public void update(int i , int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    // 计算区间和
    int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}


