package leetcode;

import java.util.PriorityQueue;

public class Code_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        for (int i = 1; i <= n; i++) {
            long x = queue.poll();
            if (i == n) {
                return (int) x;
            }
            for (int prime : primes) {
                if (prime <= Integer.MAX_VALUE / x) {
                    queue.add(prime * x);
                }
                if (x % prime == 0) {
                    break;
                }
            }
        }
        return -1;
    }
}
