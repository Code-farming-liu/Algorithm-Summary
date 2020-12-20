package offer;

/**
 * @ClassName: Test07
 * @Description: 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 题解 讨论 通过的代码笔记 纠错 收藏
 * @Author: Admin
 **/

public class Code_06 {
    /**
     * @return int
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以利用前半部分有序，后半部分有序，使用二分查找（注：暴力破解不做过多解释）。
     * 如果中间的值 mid 大于 最右边的值，则证明我们找的最小值肯定在 右半部分，因此 左边界为 mid + 1;
     * 如果中间的值 mid 等于 最右边的值，我们找的最小值无法确定，但是肯定比最后一个数小，因此右边界缩小。
     * 如果中间的值 mid 小于 最右边的值，证明我们找的最小值在 左半部分，因此 右边界缩小为 mid ；
     * 最后的左边界即为需要查找的最小值。
     * @Param [array]
     **/
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}