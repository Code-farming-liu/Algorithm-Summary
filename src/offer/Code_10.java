package offer;

/**
 * @ClassName: Test10
 * @Description: 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * @Author: Admin
 **/

public class Code_10 {
    /**
     * @param target
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以动手去多画几个，寻找规律 ，我们会逐渐发现特点：
     * 当目标值为0时，则返回0；
     * 当目标值为1时，则返回1；
     * 当目标值为2时，则返回2
     * 之后我们便会发现 其结果其实就是一个斐波那契数列（如果不知道斐波那契数列可以看看我前面写的）。
     * @return: int
     */
    public int RectCover(int target) {
        int pre = 1, next = 2, res = 0;
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            for (int i = 3; i <= target; i++) {
                res = pre + next;
                pre = next;
                next = res;
            }
        }
        return res;
    }
}