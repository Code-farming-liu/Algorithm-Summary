package offer;

/**
 * @ClassName: Test42
 * @Description: 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @Author: Admin
 **/

public class Code_48 {
    /**
     * @param num1
     * @param num2
     * @Author: Admin
     * @Description: 思路描述
     * 这道题 我们很容易想到 不用加减乘除 做加法那么我们就会联想到 计算机底层的存储是使用二进制进行存储的，因此我们需要使用二进制进行运算，
     * 我们知道 异或可以求两个数的和， 对应的我们考虑对应的进位
     * 然后在使用进位 与其和求和 循环此过程即可
     * @return: int
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            //求和
            int temp = num1 ^ num2;
            //求进位
            int carry = (num1 & num2) << 1;
            num1 = temp;
            num2 = carry;
        }
        return num1;
    }
}