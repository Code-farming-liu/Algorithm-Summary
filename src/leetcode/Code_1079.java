package leetcode;

import java.util.Arrays;

/**
 * @ClassName: Code_1079
 * @Description: 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * @Author: Admin
 **/

public class Code_1079 {

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        int[] res = new int[1];
        dfs(res, visited, chars, 0);
        return res[0];
    }


    public void dfs(int[] res, boolean[] visited, char[] chars, int depth) {
        if (depth == chars.length) {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            // 剪枝
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                res[0]++;
                dfs(res, visited, chars, depth + 1);
                visited[i] = false;
            }
        }
    }

    public int numTilePossibilities1(String tiles) {
        char[] chars = tiles.toCharArray();
        //先排序，目的是让相同的字符挨着，在下面计算的时候好过滤掉重复的
        Arrays.sort(chars);
        int[] res = new int[1];
        backtrack(res, chars, new boolean[tiles.length()], tiles.length(), 0);
        return res[0];
    }

    private void backtrack(int[] res, char[] chars, boolean[] used, int length, int index) {
        //如果没有可以选择的就返回
        if (index == length)
            return;
        //注意，这里的i每次都是从0开始的，不是从index开始
        for (int i = 0; i < length; i++) {
            //一个字符只能选择一次，如果当前字符已经选择了，就不能再选了。
            if (used[i])
                continue;
            //过滤掉重复的结果
            if (i - 1 >= 0 && chars[i] == chars[i - 1] && !used[i - 1])
                continue;
            //选择当前字符，并把它标记为已选择
            used[i] = true;
            res[0]++;//选择一个字符，就多了一种结果
            //下一分支继续递归
            backtrack(res, chars, used, length, index + 1);
            //使用完之后再把它给复原。
            used[i] = false;
        }
    }
}