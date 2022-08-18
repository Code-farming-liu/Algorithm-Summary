package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code_241 {
    private String[] arr;
    public List<Integer> diffWaysToCompute(String expression) {
        String[] sign = expression.split("[0-9]+]"), nums = expression.split("\\D");
        arr = new String[Math.max(0, sign.length - 1) + nums.length];
        for (int i = 0, sIdx = 1, nIdx = 0; i < arr.length; i++) {
            arr[i] = (i & 1) == 1 ? sign[sIdx++] : nums[nIdx++];
        }
        List<Integer>[][] dp = new List[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(dp, 0, arr.length - 1);
    }

    private List<Integer> dfs(List<Integer>[][] dp, int left, int right) {
        if (dp[left][right].isEmpty()) {
            if (left == right) {
                dp[left][right].add(Integer.parseInt(arr[left]));
            } else {
                for (int i = left + 1; i <= right - 1; i += 2) {
                    for (int leftRes : dfs(dp, left, i - 1)) {
                        for (int rightRes : dfs(dp, i + 1, right)) {
                            dp[left][right].add(calculate(leftRes, rightRes, arr[i]));
                        }
                    }
                }
            }
        }
        return dp[left][right];
    }

    private int calculate(int a, int b, String op) {
        int ans;
        switch(op) {
            case "+":
                ans = a + b;
                break;
            case "-":
                ans = a - b;
                break;
            case "*":
                ans = a * b;
                break;
            default:
                ans = 0;
        }
        return ans;
    }
}
