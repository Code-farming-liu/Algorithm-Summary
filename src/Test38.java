import java.util.ArrayList;

/**
 * @ClassName: Test38
 * @Description: 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Author: Admin
 **/

public class Test38 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(sum <= 2) {
            return res;
        }
        int slow = 0;
        int fast = array.length - 1;
        while(slow < fast) {
            int cur = array[slow] + array[fast];
            if(cur == sum) {
                res.add(array[slow]);
                res.add(array[fast]);
                break;
            } else if(cur < sum){
                slow++;
            } else {
                fast--;
            }
        }
        return res;
    }
}