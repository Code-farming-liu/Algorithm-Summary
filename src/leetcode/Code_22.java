package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: Test56
 * @Description: 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @Author: Admin
 **/

public class Code_22 {
    // 做减法

    /**
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * <p>
     * 使用dfs算法，我们要注意只有当左括号数量大于右括号的数量才会进行剪枝。
     * 使用dfs利用全排列的方式，利用结果中的左括号的数量大于右括号的数量才会剪枝
     * 利用递归回溯的算法，将对应的结果集进行回溯。
     * @return: java.util.List<java.lang.String>
     */
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res, i);
        for (String re : res) {
            System.out.println(re);
        }
        return res;
    }

    int i = 0;

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res, int count) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res, i++);
            System.out.println(curStr);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res, i++);
            System.out.println(curStr);
        }
    }

    //方法二 广度优先遍历

    /**
     * @param null
     * @Author: Admin
     * @Description: 层次遍历BFS
     * 也就是每一种结果作为一层，当左括号 大于右括号剪枝，其实利用和上面相同的思路。
     * @return: null
     */
    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis3(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.add(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.add(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }


    //     把结果集保存在动态规划的数组里
    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

//    int i = 0;

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n, i);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max, int count) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max, i++);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max, i++);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}