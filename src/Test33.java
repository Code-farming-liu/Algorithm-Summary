/**
 * @ClassName: Test33
 * @Description: 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * @Author: Admin
 **/

public class Test33 {
    public int GetNumberOfK(int [] array , int k) {
        int first = binarySearch(array,k);
        int end = binarySearch(array, k + 1);
        return (first == array.length || array[first] != k) ? 0 : end - first;
    }
    public int binarySearch(int[] nums,int temp){
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= temp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}