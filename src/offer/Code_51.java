package offer;

/**
 * @ClassName: Test45
 * @Description: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 * B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 题解 讨论 通过的代码笔记 纠错 收藏
 * @Author: Admin
 **/

public class Code_51 {
    /**
     * @param A
     * @Author: Admin
     * @Description: 思路描述：
     * <p>
     * 我们可以使用左右两个数组的方式进行辅助，
     * 左边数组，为 当前元素左边所有元素的乘积，
     * 右边数组为当前元素右边所有元素的乘积，
     * 最后的结果即为 左边与右边的乘积，
     * 注意
     * 第一个数的左边没有元素设置为1，
     * 最后一个数右边没有元素设置为1。
     * @return: int[]
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        //初始化左右两个数组
        int[] left = new int[len];
        int[] right = new int[len];
        //结果数组
        int[] ans = new int[len];
        //左边数组的第一个数 因为是第一个数 肯定没有元素 因为后面需要使用乘积设置为1
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }
        //右边数组的最后一个数 因为是最后一个数 肯定没有元素 因为后面需要使用乘积设置为1
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = A[i + 1] * right[i + 1];
        }
        //左边对应的结果 * 右边对应的结果 最后则为最终的结果
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}