/**
 * @ClassName: Test22
 * @Description: 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * @Author: Admin
 * @Date 2020/9/3 15:24
 **/

public class Test22 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }
    public boolean isBST(int[] num, int start, int end){
        if(end <= start){
            return true;
        }
        //找到左子树
        int i = start;
        for(; i < end; i++){
            if(num[i] > num[end]){
                break;
            }
        }
        for(int j = i; j < end; j++){
            if(num[j] < num[end]){
                return false;
            }
        }
        return isBST(num,start, i - 1) &&
                isBST(num, i, end - 1);
    }
}