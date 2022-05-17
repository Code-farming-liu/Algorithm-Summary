package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Code_45 {
    public static int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> queue = new ArrayDeque<>();
        visited[0] = true;
        queue.addLast(0);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer index = queue.pollFirst();
                // 到最后节点
                if (index == nums.length - 1) {
                    return res;
                }
                for (int j = index + 1; j <= nums[index] + index && j < nums.length; j++) {
                    if (!visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 1};
        System.out.println(jump(nums));
    }
}
