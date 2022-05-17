package leetcode;

public class Code_172 {
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(13));
        long res = 1;
        for (int i = 1; i <= 13; i++) {
            res *= i;
        }
        System.out.println(res);
    }
}
