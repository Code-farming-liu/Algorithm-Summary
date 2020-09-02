/**
 * @ClassName: Test09
 * @Description: 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @Author: Admin
 **/

public class Test09 {
    //迭代
//    public int JumpFloor(int target) {
//
//        if (target <= 0) {
//            return 0;
//        }
//        if (target == 1) {
//            return 1;
//        }
//        if (target == 2) {
//            return 2;
//        }
//        int result = 0;
//        int a = 1;
//        int b = 2;
//        for (int i = 2; i < target; i++) {
//            result = a + b;
//            a = b;
//            b = result;
//        }
//        return result;
//    }

    //递归
    public int JumpFloor(int target) {
        if(target == 0){
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
