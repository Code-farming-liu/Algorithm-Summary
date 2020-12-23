package leetcode;

import java.util.*;

/**
 * @ClassName: Test64
 * @Description: 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @Author: Admin
 **/

public class Code_56 {
    //先排序 然后判断 下一个区间的左端点是不是小于等于当前区间的右端点 满足条件进行合并

    /**
     * @param intervals
     * @Author: Admin
     * @Description: 思路描述：
     * 这种我们可以首先对 区间的左端点进行排序，
     *
     * 如果是可合并的 那么左端点一定是连续的，
     *
     * 然后判断当前区间的右端点是不是大于下一个区间的左端点，
     * 如果小于，那么将当前区间的左端点作为新区间的左端点，右端点为两个区间最大的右端点。
     *
     * 可以用一个队列来进行辅助完成
     * @return: int[][]
     */
    public int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= list.getLast()[1]) {
                //新区间的 左端点为 第一个区间的左端点 右端点为 俩个区间最大的右端点
                int max = Math.max(curr[1], list.getLast()[1]);
                int start = list.getLast()[0];
                list.removeLast();
                list.addLast(new int[]{start, max});
            } else {
                //不满足条件 就直接将本区间加入到LinkedList中
                list.addLast(curr);
            }
        }

        return list.toArray(new int[0][2]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] merge = new int[intervals.length][];
        int length = 0;
        for (int[] pair : intervals) {
            if (length == 0 || merge[length - 1][1] < pair[0]) {
                merge[length++] = pair;
            } else {
                merge[length - 1][1] = Math.max(merge[length - 1][1], pair[1]);
            }
        }
        int[][] res = new int[length][];
        System.arraycopy(merge, 0, res, 0, length); 
        return res;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    }

    //
    public int[][] merge3(int[][] intervals) {
        List<Interval> intervalsList = new LinkedList<>();
        for (int[] interval : intervals) {
            intervalsList.add(new Interval(interval));
        }
        intervalsList.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervalsList) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        int i = 0;
        int[][] result = new int[merged.size()][2];
        for (Interval mergedInterval : merged) {
            result[i] = mergedInterval.toArray();
            i++;
        }
        return result;
    }

    public int[][] merge4(int[][] arr) {
        Arrays.parallelSort(arr, Comparator.comparingInt(x -> x[0]));

        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.size() == 0 || list.getLast()[1] < arr[i][0]) {
                list.add(arr[i]);//集合为空，或不满足条件，向后新增
            } else {//满足条件，集合最后元素的end=最大值
                list.getLast()[1] = Math.max(list.getLast()[1], arr[i][1]);
            }
        }
        int[][] res = new int[list.size()][2];//生成结果数组
        int index = 0;
        while (!list.isEmpty()) {//遍历集合
            res[index++] = list.removeFirst();//删除集合首元素
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        //为什么放0，0长度？可以看下源码就知道了
        return res.toArray(new int[0][0]);
    }

    public int[][] merge5(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        //排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //判断边界 同时判断 当前的区间右端点是不是 是不是大于下一个区间的左端点
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                //右端点取 两个区间右端点的最大值
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
