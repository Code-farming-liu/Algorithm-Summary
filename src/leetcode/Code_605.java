package leetcode;

/**
 * @ClassName: Code_605
 * @Description: 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
 * 和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * @Author: Admin
 **/

public class Code_605 {
    /**
     * @param flowerbed
     * @param n
     * @Author: Admin
     * @Description: 思路描述：
     * 我们假设最左边可以种花，那么我们就可以发现只要有三个位置连续都不种花，
     * 那么该位置肯定可以种一个花，如果到了数组的最后还有两个连续的位置没有种花，
     * 那么最右边的地方肯定可以种一朵花。
     * @return: boolean
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 假设在最左边种花，也就是数组的左边是 0
        int count = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            // 统计有几个连续的 0
            count = flowerbed[i] == 0 ? count++ : 0;
            // 三个连续的0种花
            if (count == 3) {
                n--;
                count = 1;
            }
        }
        // 如果有两个连续的0， 那么最后一个位置也可以种花
        if (count == 2) {
            n--;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1);
    }
}