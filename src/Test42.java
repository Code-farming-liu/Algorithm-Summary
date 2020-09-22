/**
 * @ClassName: Test42
 * @Description: 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @Author: Admin
 **/

public class Test42 {
    public int Add(int num1,int num2) {
        while(num2 != 0) {
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