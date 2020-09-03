import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: Test27
 * @Description: 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @Author: Admin
 * @Date 2020/9/3 16:05
 **/

public class Test27 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length == 0 || k > input.length){
            return new ArrayList<>();
        }
        Arrays.sort(input);
        for(int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}