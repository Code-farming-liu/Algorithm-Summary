package algorithmFourth.first;

/**
 * @ClassName: Test1_1_13
 * @Description: 转置矩阵
 * @Author: Admin
 * @Date 2021/5/1 21:22
 **/

public class Test1_1_22 {
    static int depth = 0;
    public static int rank(int[] nums, int target, int left, int right) {
        depth++;
        if (left > right) {
            return -1;
        }
        System.out.println("left = " + left + "right = " + right);
        int mid = left + (right - left) / 2;
        if (target > nums[mid]) {
            return rank(nums, target, mid + 1, right);
        } else if (target < nums[mid]) {
            return rank(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(rank(nums, 4, 0, nums.length - 1));
        System.out.println(depth);
    }
}