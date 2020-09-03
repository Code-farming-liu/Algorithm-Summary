import java.util.Arrays;

/**
 * @ClassName: Test26
 * @Description: 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author: Admin
 **/

public class Test26 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int count = 0;
        for(int num : array) {
            if(num == array[array.length / 2]){
                count++;
            }
        }
        return count > array.length / 2 ? array[array.length / 2] : 0;
    }
}