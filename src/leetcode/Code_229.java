package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int count = 0, base = nums.length / 3, temp = 0;
        Arrays.sort(nums);
        for (Integer num : nums) {
            if (temp != num) {
                count = 0;
            }
            temp = num;
            count++;
            if (count > base) {
                res.add(temp);
            }
        }
        return res;
    }
}
