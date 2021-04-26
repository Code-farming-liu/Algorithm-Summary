package leetcode;

/**
 * @ClassName: Code_1011
 * @Description: 在D天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * @Author: Admin
 **/

public class Code_1011 {
    /**
     * @param weights
     * @param D
     * @Author: Admin
     * @Description:
     * 我们使用对应的二分查找法进行查找，
     * 我们可以知道对应的下限就是重量最大的那个值，上限就是数组的和
     *
     * 根据这个范围二分查找我们所需要的答案，
     *
     * 如果某个答案所需要的天数小于目标天数那么我们就直接将其右边界缩小
     *
     * 如果所需的天数大于目标天数，那么我们直接将其左边界增大
     *
     * 最终找到结果。
     * @return: int
     */
    public static int shipWithinDays(int[] weights, int D) {
        int left = findLeft(weights);
        int right = findRight(weights);
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findLeft(int[] weight) {
        int res = Integer.MIN_VALUE;
        for (int num : weight) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static int findRight(int[] weight) {
        int res = 0;
        for (int num : weight) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }
}