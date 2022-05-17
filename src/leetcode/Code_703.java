package leetcode;

import java.util.PriorityQueue;

public class Code_703 {
    PriorityQueue<Integer> queue = null;
    int k = 0;
    public Code_703(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
