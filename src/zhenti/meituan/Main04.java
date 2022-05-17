package zhenti.meituan;

public class Main04 {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] nums = {25, 34, 33, 46, 49, 31};
        new Main04().dfs(0, 0, nums);
        System.out.println(res);
    }

    public void dfs(int index, int sum, int[] nums) {
        if (sum > 70) {
            res = Math.min(res, sum);
        }
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            dfs(i + 1, sum, nums);
            sum -= nums[i];
        }
    }
}
