package leetcode;

/**
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 *  
 *
 * 示例 1：
 *
 * 输入：left = 6, right = 10
 * 输出：4
 * 解释：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * 示例 2：
 *
 * 输入：left = 10, right = 15
 * 输出：5
 * 解释：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 *  
 *
 * 提示：
 *
 * 1 <= left <= right <= 106
 * 0 <= right - left <= 104
 *
 */
public class Code_762 {
    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(count(i))) {
                count++;
            }
        }
        return count;
    }

    public static int count(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        return count;
    }

    // 判断是否是质数
    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    static boolean[] hash = new boolean[40];
    static {
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int x : nums) hash[x] = true;
    }
    public int countPrimeSetBits1(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int x = i, cnt = 0;
            while (x != 0 && ++cnt >= 0) x -= (x & -x);
            if (hash[cnt]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }
}
