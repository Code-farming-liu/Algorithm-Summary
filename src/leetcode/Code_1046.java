package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: Code_1046
 * @Description: 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * @Author: Admin
 **/

public class Code_1046 {
    /**
     * @param stones
     * @Author: Admin
     * @Description: 思路描述：
     * 我们只需要每次都将数组进行排序，之后取出最后两个数，
     * 我们将对应的x 的值进行覆盖，对应缩短数组的长度
     * @return: int
     */
    public static int lastStoneWeight(int[] stones) {
        int x = 0;
        int y = 0;
        int length = stones.length;
        if (length == 2) {
            return Math.abs(stones[1] - stones[0]);
        }
        for (int i = length - 2; i >= 0; i--) {
            Arrays.sort(stones);
            x = stones[length - 2];
            y = stones[length - 1];
            int temp = y - x;
            stones[i] = temp;
            length--;
        }
        return stones[0];
    }

    /**
     * @param stones
     * @Author: Admin
     * @Description: 思路描述
     * 我们可以使用大顶堆进行辅助遍历 ，每次弹出两个最大的值，
     *
     * 1. 两个数相等，那么直接跳过
     * 2. 两个数不相等，我们直接将他们的差值加入到大顶堆中
     * @return: int
     */
    public int lastStoneWeight1(int[] stones) {
        int length = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(length, (a, b) -> b - a);
        for (int num : stones) {
            maxHeap.offer(num);
        }

        while (maxHeap.size() >= 2) {
            Integer y = maxHeap.poll();
            Integer x = maxHeap.poll();
            if (y.equals(x)) {
                continue;
            }
            maxHeap.offer(y - x);
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        lastStoneWeight(new int[]{3, 7, 8});
    }
}