package offer;

/**
 * @ClassName: Test30
 * @Description: 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Author: Admin
 **/

public class Code_33 {
    /**
     * @param index
     * @Author: Admin
     * @Description: 思路描述：
     * 我们从数组中只包含一个丑数数字1开始，使用三个指针 i2,i3,i5，标记指向丑数要乘的因子
     * 如 在 2 * nums[i2],3 * nums[i3]和 5 * nums[i5] 选出最小的一个丑数 添加到数组中，
     * 将丑数对应的因子指针向前走一步，重复该步骤直到 计算完 n个丑数. 最后返回index - 1个丑数即可
     * @return: int
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int temp = 1, p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            temp = Math.min(Math.min(nums[p2] * 2, nums[p3] * 3), nums[p5] * 5);
            nums[i] = temp;
            if (temp == nums[p2] * 2) {
                p2++;
            }
            if (temp == nums[p3] * 3) {
                p3++;
            }
            if (temp == nums[p5] * 5) {
                p5++;
            }
        }
        return nums[index - 1];
    }
}