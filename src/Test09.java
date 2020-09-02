/**
 * @ClassName: Test09
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/9/2 18:30
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