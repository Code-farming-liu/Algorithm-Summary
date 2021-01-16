package leetcode;

/**
 * @ClassName: Code_88
 * @Description: 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * @Author: Admin
 **/

public class Code_88 {
    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以使使用两个指针，分别指向两个需要合并的数组，使用一个新的指针指向一个临时的数组，每次比较两个数组中对应的元素，加入到新的数组之中。
     *
     * 1. 当num1[p1] < num2[p2]   则  res[i++] = num2[p1++]
     * 2. 否则 res[i++] = num2[p2++]
     * 3. 将剩余的元素直接加入到临时数组之中
     * 4. 最后将新的数组，转移到num1中即可
     * @return: void
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                res[i++] = nums1[p1++];
            } else {
                res[i++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            res[i++] = nums1[p1++];
        }
        while (p2 < n) {
            res[i++] = nums2[p2++];
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = res[i];
        }
    }
}