package zuoshendata.zuoshen4.basic.class01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/4/4 17:39
 **/

public class Test {
    public static void main(String[] args) {
        new Test().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] nums = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = count++;
            }
        }
        return print(nums);
    }


    public int[][] print(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        int m = nums.length;
        int n = nums[0].length;
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while (up <= down && left <= right) {
            // 向右走
            List<Integer> list1 = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                list1.add(nums[up][i]);
            }
            res.add(list1);
            // 向下走
            List<Integer> list2 = new ArrayList<>();
            for (int i = up + 1; i <= down; i++) {
                list2.add(nums[i][right]);
            }
            res.add(list2);
            if (left < right && up < down) {
                // 向左走
                List<Integer> list3 = new ArrayList<>();
                for (int i = right - 1; i >= left; i--) {
                    list3.add(nums[down][i]);
                }
                res.add(list3);
                List<Integer> list4 = new ArrayList<>();
                for (int i = down - 1; i > up; i--) {
                    list4.add(nums[i][left]);
                }
                res.add(list4);
            }
            left++;
            right--;
            up++;
            down--;
        }
        int[][] help = new int[res.size()][res.size()];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                help[i][j] = res.get(i).get(j);
            }
        }
        return help;
    }
}