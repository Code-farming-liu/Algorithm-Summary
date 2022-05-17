package leetcode;

import java.util.Arrays;

/**
 * @ClassName: TreeNode
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/9/2 14:32
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        Arrays.sort(nums);
    }
}