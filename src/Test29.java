/**
 * @ClassName: Test29
 * @Description: 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @Author: Admin
 **/

public class Test29 {
    public int NumberOf1Between1AndN_Solution(int n) {
        //当前的位置
        int index = 1;
        int count = 0;
        int high = n, low = 0,cur = 0;
        while(high > 0) {
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            if(cur == 0) {
                count += high * index;
            }
            if(cur == 1) {
                count += high * index + low + 1;
            }
            if(cur > 1) {
                count += (high + 1) * index;
            }
            index *= 10;
        }
        return count;
    }
}