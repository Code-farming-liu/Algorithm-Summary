package LeetCode;

/**
 * @ClassName: Test63
 * @Description: 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @Author: Admin
 **/

public class Code_55 {
    //解法一：

    /**
     * @param position
     * @param nums
     * @Author: Admin
     * @Description: 思路描述：
     * 从后往前推，我们要想到达最后一个位置，我们就去看它的前一个位置是不是可以到达最后一个位置，
     * 如果可以到达，那么只要到达前一个位置，肯定可以到达最后一个位置，在以前一个位置为基准以此类推。
     * @return: boolean
     */
    public static boolean canJumpFromPosition1(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition1(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public static boolean canJump1(int[] nums) {
        return canJumpFromPosition1(0, nums);
    }
    //第二种解法
    //1、因为倒数第二个位置为1，所以从倒数第二个位置可以到达最后一个位置。
    // 因此只要我们能到达倒数第二个位置就能到达最后一个位置。
    //2、因为倒数第三个位置为1，所以从倒数第三个位置可以到达倒数第二个位置。
    // 因此只要我们能到达倒数第三个位置就能到达倒数第二个位置从而能到达最后一个位置。
    //3、因为倒数第四个位置为3，所以从倒数第四个位置可以到达倒数第三个位置。
    // 因此只要我们能到达倒数第四个位置就能到达倒数第三个位置从而能到达最后一个位置。
    //4、因为倒数第五个位置为2，所以从倒数第五个位置可以到达倒数第四个位置。
    // 因此只要我们能到达倒数第五个位置（也就是第一个位置)就能到达倒数第三个位置从而能到达最后一个位置。
    //因此，可以到达最后一个位置。
    //因此，我们用一个变量pos来表示需要到达的位置，
    // 并初始化为nums.length - 1表示需要到达的位置为最后一个位置。
    //然后从nums.length - 2向前遍历，if(nums[i] + i >= pos)表示从当前位置出发能够到达pos，
    // 因此只要能到达当前位置i就可以到达pos，因此可以更新pos为i的值。
    //遍历到最后如果pos==0，也就表示从开始能够跳到末尾。

    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1; //代表的是位置
        for (int i = nums.length - 2; i >= 0; i--) {
            //当前位置出发能够到达lastPos
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}