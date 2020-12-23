package leetcode;

/**
 * ClassName: Test52
 * Description: 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 *
 * @author Admin
 * @since JDK 1.8
 */
public class Code_11 {

    public static int maxArea1(int[] height) {
        int b = 0;
        int result = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            while (true) {
                int heigths = Math.min(height[b], height[i]);
                int weigths = i - b;
                result = Math.max(result, heigths * weigths);
                if (height[b++] == height[i]) {
                    b = 0;
                    break;
                }
            }
        }
        return result;
    }
    

    //暴力破解法
    public int maxArea2(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }

    //双指针

    /**
     * @param height
     * @Author: Admin
     * @Description: 双指针
     * 在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 min(1, 7) * 8 = min(1,7)∗ 8=8。
     * <p>
     * 此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针
     * （即此时的左指针）。这是因为，由于容纳的水量是由
     * <p>
     * 两个指针指向的数字中较小值 * 指针之间的距离
     * <p>
     * 决定的。如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，
     * 后者「指针之间的距离」会减小，那么这个乘积会减小。因此，我们移动数字较大的那个指针是不合理的。
     * 因此，我们移动 数字较小的那个指针。
     * 双指针 不断移动最小的指针 知道两个指针重合 取得最大值即为结果
     * @return: int
     */
    public int maxArea3(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    public static int maxArea(int[] height) {
        int right = height.length;
        int left = 0;
        int res = 0;
        while (left < right) {
            //判断根据木桶原理 他们之间的容量是由 较短的去决定的
            int heights = Math.min(height[left], height[right]);
            //判断中间的长度
            int width = right - left;
            //计算他们之间的面积与当前的面积比较 取较大值
            res = Math.max(res, heights * width);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(a);
    }
}
