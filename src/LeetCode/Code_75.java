package LeetCode;

/**
 * @ClassName: Test67
 * @Description: 颜色分类
 * 题目描述：
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * @Author: Admin
 **/

public class Code_75 {
    //快排

    /**
     * @param nums
     * @Author: Admin
     * @Description: 思路分析：
     * 解法一：
     * 排序 快排
     * @return: void
     */
    public void sortColors1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        int l = left;//左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = array[(left + right) / 2];
        int temp = 0;
        //while循环的目的是让比pivot值小的放到左边
        //比pivot值大的放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot的值，才退出
            while (array[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot的值才退出
            while (array[r] > pivot) {
                r -= 1;
            }
            //如果 l >= r说明pivot的左右两边的值，已经按照左边全部是
            //小于等于pivot的值，右边全部是大于等于pivot的值
            if (l >= r) {
                break;
            }
            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            //如果交换完后，发现这个array[l] == pivot值 相等r--,前移
            if (array[l] == pivot) {
                r -= 1;
            }
            //如果交换完之后，发现这个array[r] == pivot值相等 l++,后移
            if (array[r] == pivot) {
                l += 1;
            }
        }
        //若果 l == r，必须l++，r--,否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归、
        if (left < r) {
            quickSort(array, left, r);
        }
        if (right > l) {
            quickSort(array, l, right);
        }
    }

    /*
        荷兰三色旗题解
    */

    /**
     * @param nums
     * @Author: Admin
     * @Description: 解法二：
     * 初始化0的最右边界：p0 = 0。在整个算法执行过程中 nums[idx < p0] = 0.
     *
     * 初始化2的最左边界 ：p2 = n - 1。在整个算法执行过程中 nums[idx > p2] = 2.
     *
     * 初始化当前考虑的元素序号 ：curr = 0.
     *
     * while curr <= p2 :
     *
     * 若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
     *
     * 若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。
     *
     * 若 nums[curr] = 1 ：将指针curr右移。
     * @return: void
     */
    public static void sortColors(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0;//左指针
        int curr = 0;//当前指针
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;//右指针

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else {
                curr++;
            }
        }
    }
}