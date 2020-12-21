package offer;

/**
 * @ClassName: Test22
 * @Description: 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @Author: Admin
 * @Date 2020/9/3 15:24
 **/

public class Code_23 {
    /**
     * @param sequence
     * @Author: Admin
     * @Description: 思路描述：
     * 我们在解决这个问题之前首先需要知道后序遍历的特点
     * 后序遍历： 左、右、根
     * 扩展
     * 前序遍历：根、左、右
     * 中序遍历：左、根、右
     * 只要去观察根的位置即可
     *
     * 因此一个后序遍历数组中最后一个节点肯定是根节点，
     * 二叉搜索树的特点：
     * 左子树的所有节点小于根节点
     * 右子树的所有节点大于根节点
     * 一个节点的左子节点肯定小于右子节点
     * 因此根据此特点可以看出 前半部分的元素都必须小于 最后一个元素，
     * 后半部分元素必须大于最后一个元素 以一个“谷底”判断分割
     * 递归分解数组，循环上述步骤。
     * @return: boolean
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    public boolean isBST(int[] num, int start, int end) {
        if (end <= start) {
            return true;
        }
        //找到左子树
        int i = start;
        for (; i < end; i++) {
            if (num[i] > num[end]) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (num[j] < num[end]) {
                return false;
            }
        }
        return isBST(num, start, i - 1) &&
                isBST(num, i, end - 1);
    }
}