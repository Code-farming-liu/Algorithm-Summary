import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test0001
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/9/17 22:51
 **/

public class Test0001 {
    public static void Lcss(char str1[], char str2[]) {
        int dp[][] = new int[str1.length][str2.length];
        //对dp矩阵的第一列赋值
        for (int i = 0; i < str1.length; i++) {
            if (str2[0] == str1[i])
                dp[i][0] = 1;
            else {
                dp[i][0] = 0;
            }
        }
        //对dp矩阵的第一行赋值
        for (int j = 0; j < str2.length; j++) {
            if (str1[0] == str2[j])
                dp[0][j] = 1;
            else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < str1.length; i++)
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        int max = dp[0][0];
        for (int i = 0; i < str1.length; i++)
            for (int j = 0; j < str2.length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Test0001 test0001 = new Test0001();
        char[] chars1 = {'a', 'b', 'c'};
        char[] chars2 = {'c', 'a', 'b', 'a'};
//        test0001.Lcss(chars1, chars2);
    }
}

class A {
    public void subsets(int[] array) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[array.length];
//        for (int i = 0; i < array.length; i++) {
            dfs(0, list, res, array, visit);
//        }
        System.out.println(res.toString());
    }

    public void dfs(int index, List<Integer> list, List<List<Integer>> res, int[] array, boolean[] visit) {
        int length = array.length;
        res.add(new ArrayList<>(list));
        for (int i = index; i < length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(array[i]);
                dfs(index + 1, list, res, array, visit);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new A().subsets(new int[]{1, 2, 3});
    }
}