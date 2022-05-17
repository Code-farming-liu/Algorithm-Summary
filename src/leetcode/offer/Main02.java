package leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;

public class Main02 {
    public static void main(String[] args) {
        int[][] nums = {
                {5, 3},
                {9, 2},
                {4, 1}
        };
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i][1] > 2 * nums[j][1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
