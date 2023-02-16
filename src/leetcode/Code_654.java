package leetcode;

import java.util.Arrays;

/**
 * 最大二叉树
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 */
public class Code_654 {
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        TreeNode node = new TreeNode(0);
        // 到了叶子结点返回
        if (nums.length == 1) {
            node.val = nums[0];
            return node;
        }
        // 找到数组中最大值和坐标
        int maxVal = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        node.val = maxVal;
        // 构造左子树, 最少有一个
        if (maxIndex > 0) {
            int[] t = Arrays.copyOfRange(nums, 0, maxIndex);
            node.left = constructMaximumBinaryTree(t);
        }
        // 构造右子树,最少有一个
        if (maxIndex < nums.length - 1) {
            int[] t = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
            node.right = constructMaximumBinaryTree(t);
        }
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length);
    }


    public TreeNode help(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        // 找最大下标
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        // 构建左子树
        root.left = help(nums, left, maxIndex);
        // 构建右子树
        root.right = help(nums, maxIndex + 1, right);
        return root;
    }
}
