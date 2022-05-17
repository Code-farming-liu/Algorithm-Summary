package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code_6031 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                list.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (Math.abs(i - list.get(j)) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2,2,2,2,2};
        System.out.println(new Code_6031().findKDistantIndices(num, 2, 2));
    }
}



