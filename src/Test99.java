/**
 * @ClassName: Test99
 * Description: 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @Author: Admin
 **/

public class Test99 {
    public static int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //记录前n个数的最大长度，寻找出最大长度
        int[] maxLen = new int[nums.length];
        maxLen[0] = 1;//因为初始值 肯定为1 自己本身
        int result = 1;//保存最后的结果
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = 0;//保存临时的最大值
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { //
                    maxTemp = Math.max(maxTemp, maxLen[j]);//比较临时最大值和当前最大值的大小
                }
            }
            maxLen[i] = maxTemp + 1;//因为要加上自身 所以 + 1
            result = Math.max(maxLen[i], result);
        }
        return result;
    }

    //动态规划 + 贪心 + 二分查找法
    //思路是：
//创建数组tails用来保存从左到右遍历数组所得的最长上升子序列；
//每遍历一个元素时，都使用二分查找法找到该元素应该在tails数组的索引；
//
//关于元素替换：
//像序列10,9,2,5,3,7,21,18
//它在遍历时会遇到tails数组由2,5,7 👉 2,3,7
//元素3替换了元素5的位置，在暂时遍历到这里时，3和5都在2和7之间，它们是处于同一水平位置的，所以替换后并不会影响结果；
//而会为后面万一出现3和5中间的数（例如：4，他将代替5，会和3处同一水平位置）这种特殊情况做准备；
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                //二分查找法
                int m = (i + j) / 2;
                //前面的值比 当前值小 直接当前值往后查找 更新左边界
                if (tails[m] < num) {
                    i = m + 1;
                } else {//更新右边界
                    j = m;
                }
            }
            //始终更新对应的值
            tails[i] = num;
            //tails 数组去除0后的长度
            //不断更新数组的长度
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}