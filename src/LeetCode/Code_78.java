package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test68
 * @Description: 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * @Author: Admin
 * @Date 2020/11/15 11:44
 **/

public class Code_78 {
    //集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。 ?????
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //1<<nums.length 等价于 2^nums.length,对于n个数字的数组，共2^n个子集；
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                //以0~(2^n)-1，2^n个n位二进制数，对应于所有子集，
                // 从后往前第 j 个二进制位为 0 表示不放入第 j 个元素, 同理1表示放入。
                // " ((i >> j) & 1) == 1 " 表示对于二进制数i，
                // 从低位到高位逐个取其二进制位，并判断是否为1，若为1则放入对应nums中的元素。
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }


    //逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    public void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }
}