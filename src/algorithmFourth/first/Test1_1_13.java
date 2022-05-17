package algorithmFourth.first;

/**
 * @ClassName: Test1_1_13
 * @Description: 转置矩阵
 * @Author: Admin
 * @Date 2021/5/1 21:22
 **/

public class Test1_1_13 {
    public static void test(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        test(nums);
    }
}