package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Code_658
 * @Description: 找到K个最接近的元素
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 * @Author: Admin
 **/

public class Code_658 {
    /**
     * @param arr
     * @param k
     * @param x
     * @Author: Admin
     * @Description: https://leetcode-cn.com/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        int removeCount = arr.length - k;
        while (removeCount > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeCount--;
        }
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }
        return list;
    }


    public static void main(String[] args) {
        new Code_658().findClosestElements(new int[]{1}, 1, 1);
    }
}