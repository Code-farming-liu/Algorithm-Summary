package offer;

/**
 * @ClassName: Test33
 * @Description: 数字在排序数组中出现的次数
 * 统计一个数字在升序数组中出现的次数。
 * @Author: Admin
 **/

public class Code_37 {
    /**
     * @param array
     * @param k
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以从题目中提取出来 升序数组，因此首先想到使用对应的二分查找，但是是要找出现的次数，
     * 因此我们只需要找到 该数字出现的开始 和结尾就可以找到对应的次数（结尾 - 开始）
     * 开始肯定好找，我们不断二分逼近，最后返回左边界即为开始的下标，
     * 结尾部分有一定的难度，但是我们可以这么思考 升序数组，因此出现的次数，不就代表是一个重复的数，
     * 因此我们直接查找比目标值大一的数找到这个数字的下标
     * 这里还有个好处就是 我们都知道数组的下标从0开始，因此我们最终的结果
     * 肯定是 end - start + 1为最终的次数，但是我们找到比目标值大一的位置，就可以避免这个问题。
     * @return: int
     */
    public int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);
        int end = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : end - first;
    }

    public int binarySearch(int[] nums, int temp) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= temp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}