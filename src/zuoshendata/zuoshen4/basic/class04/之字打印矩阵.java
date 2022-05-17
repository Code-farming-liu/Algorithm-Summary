package zuoshendata.zuoshen4.basic.class04;

/**
 * @ClassName: 之字打印矩阵
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/15 16:26
 **/

public class 之字打印矩阵 {

    public static void print(int[][] nums) {
        int m = nums.length - 1;
        int n = nums[0].length - 1;
        boolean flag = false;
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        while (aR != m + 1) {
            print(nums, aR, aC, bR, bC, flag);
            aR = aC == n ? aR + 1 : aR;
            aC = aC == n ? aC : aC + 1;
            bC = bR == m ? bC + 1 : bC;
            bR = bR == m ? bR : bR + 1;
            flag = !flag;
        }
        System.out.println();
    }

    public static void print(int[][] nums, int aR, int aC, int bR, int bC, boolean flag) {
        if (flag) {
            while (aR != bR + 1) {
                System.out.print(nums[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(nums[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        print(nums);
    }
}