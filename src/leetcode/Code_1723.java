package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Code_1723
 * @Description: 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * <p>
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * 示例 2：
 * <p>
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 * @Author: Admin
 **/

public class Code_1723 {
    //尽可能小的最大工作时间
    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        backtrack(jobs, 0, new int[k], 0);
        return res;
    }

    private void backtrack(int[] jobs, int i, int[] worker, int max) {
        //边界条件判断
        if (i == jobs.length) {
            res = Math.min(res, max);
            return;
        }
        //记录计算过的，如果同一层相同的值已经被计算过了，就不需要在计算了
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < worker.length; j++) {
            //同一层相同的值已经计算过了，就不需要在计算了，直接跳过
            if (!set.add(worker[j])) {
                continue;
            }
            //如果时间已经超过之前找的【尽可能小的最大工作时间】，
            //就跳过
            if (worker[j] + jobs[i] >= res) {
                continue;
            }
            //选择
            worker[j] += jobs[i];
            backtrack(jobs, i + 1, worker, Math.max(worker[j], max));
            //撤销选择
            worker[j] -= jobs[i];
        }
    }
}