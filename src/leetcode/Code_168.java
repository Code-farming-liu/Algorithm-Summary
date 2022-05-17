package leetcode;

/**
 * @ClassName: Code_168
 * @Description: Excel表列名称
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *  
 *
 * 示例 1：
 *
 * 输入：columnNumber = 1
 * 输出："A"
 * 示例 2：
 *
 * 输入：columnNumber = 28
 * 输出："AB"
 * 示例 3：
 *
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 示例 4：
 *
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *  
 *
 * 提示：
 *
 * 1 <= columnNumber <= 231 - 1
 *
 * @Author: Admin
 **/

public class Code_168 {

    // 我的理解 不知道对不对😄 题目转化成十进制转26进制问题
    //使用-1 熨平取模的问题。
    //因为x%26=[0,25] 但是我们取从[1-26]对应[A-Z] 直接取模 26%26=0 不在我们范围内
    //所以我们采用-1 [0-25]对应[A-Z] (26-1)%26 =25 25+'A'='Z'
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            res.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }


    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}