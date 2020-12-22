package offer;

import java.util.Arrays;

/**
 * @ClassName: Test44
 * @Description: 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Author: Admin
 **/

public class Code_50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * @param numbers
     * @param length
     * @param duplication
     * @Author: Admin
     * @Description: 思路描述：
     *
     * 我们只需要将原来的数组排序，判断下一个的值和上一个之是否相同 相同即为重复，
     * 直接返回true即可，否则返回fasle。
     * @return: boolean
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0) {
            duplication[0] = -1;
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 1; i < length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}