/**
 * @ClassName: TestHeap
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/11/21 21:42
 **/

public class TestHeap {
    public static void main(String[] args) {
        int[] nums = {4, 6, 8, 5, 9};
        int len = nums.length;
        int temp = (len / 2) - 1;

        if (nums[temp] < nums[temp] || nums[temp] < nums[temp + 2]) {

        }

    }
    public void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
