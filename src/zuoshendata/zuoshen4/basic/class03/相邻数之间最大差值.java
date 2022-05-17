package zuoshendata.zuoshen4.basic.class03;

/**
 * @ClassName: 相邻数之间最大差值
 * @Description: 不使用对应的 比较
 * @Author: Admin
 * @Date 2020/12/13 17:52
 **/

public class 相邻数之间最大差值 {
    public static int maxGap(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int length = array.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 找到数组中的最小值和最大值
        for (int i = 0; i < length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        if (max == min) {
            return 0;
        }

        boolean[] hasNum = new boolean[length + 1];
        int[] maxs = new int[length + 1];
        int[] mins = new int[length + 1];
        int bid = 0;

        for (int i = 0; i < length; i++) {
            bid = bucket(array[i], length, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], array[i]) : array[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], array[i]) : array[i];
            hasNum[bid] = true;
        }
        
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= length; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //确定当前数位于哪个桶中
    private static int bucket(long num, long length, long min, long max) {
        //也就是 以当前数的范围为长度分割 占总范围的什么部分
        return (int)((num - min) * length / (max - min));
    }

}