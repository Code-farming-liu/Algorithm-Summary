package zhenti.meituan09;

import java.io.*;

public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        while (t > 0) {
            int n = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            String[] split = str.split(" ");
            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(split[i]);
                nums[i] = num;
                sum += num;
            }
            int res = help(nums, n, sum);
            writer.write(Integer.toString(res));
            writer.newLine();
            t--;
        }
        writer.flush();
//        int[] nums = {3, -2, 4, -1};
//        help(nums, 4);
    }

    public static int help(int[] nums, int n, int sum) {
        int dpMax = nums[0];
        int max = nums[0];
        int dpMin = nums[0];
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            dpMax = Math.max(nums[i], dpMax + nums[i]);
            max = Math.max(dpMax, max);
            dpMin = Math.min(nums[i], dpMin + nums[i]);
            min = Math.min(dpMin, min);
        }
        return Math.max(max, sum - min);
    }
}
