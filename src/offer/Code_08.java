package offer;

/**
 * @ClassName: Test09
 * @Description: 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * （先后次序不同算不同的结果）。
 * @Author: Admin
 **/

public class Code_08 {
    //迭代
    /**
     * @Author: Admin
     * @Description: 思路描述：
     * 我们可以使用 穷举，可以发现有一定的规律
     * 当目标值为0时，则返回0
     * 当目标值为1时，则返回1
     * 当目标值为2时，则返回2
     * 其余情况 要想到达终点 就是 到达 n - 1 台阶处 与 n - 2台阶处的和
     * 当然我们也可以使用两个变量，进行迭代遍历
     * @param target
     * @return: int
     */
    public int JumpFloor1(int target) {

        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int result = 0;
        int a = 1;
        int b = 2;
        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    //递归
    /**
     * @Author: Admin
     * @Description: 思路描述
     * 我们可以使用 穷举，可以发现有一定的规律
     * 当目标值为0时，则返回0
     * 当目标值为1时，则返回1
     * 当目标值为2时，则返回2
     * 其余情况 要想到达终点 就是 到达 n - 1 台阶处 与 n - 2台阶处的和
     *
     * 因此我们可以使用递归实现。
     * @param target
     * @return: int
     */
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }
}
