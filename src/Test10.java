/**
 * @ClassName: Test10
 * @Description: 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 *
 * @Author: Admin
 **/

public class Test10 {
    public int RectCover(int target) {
        int pre = 1,next = 2,res = 0;
        if(target == 0){
            return 0;
        } else if(target == 1){
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            for(int i = 3; i <= target; i++){
                res = pre + next;
                pre = next;
                next = res;
            }
        }
        return res;
    }
}