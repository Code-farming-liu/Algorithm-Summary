package offer;

import java.util.Arrays;

/**
 * @ClassName: Test40
 * @Description: 扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,
 * 决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，
 * 否则就输出false。为了方便起见,你可以认为大小王是0。
 * @Author: Admin
 **/

public class Code_45 {
    /**
     * @param numbers
     * @Author: Admin
     * @Description: 思路描述：
     * 我们首先需要对
     * 数组进行排序，
     * 找出王的数量，
     * 之后根据对应的两个数之间的差值，看看是否可以使用王去补齐 可以返回true 否则false
     * 当然 如果出现一个对子 那么肯定就不是顺子 例如 7 7 x x x 怎么都不可能是顺子 因此出现对子 直接返回。
     * @return: boolean
     */
    public boolean isContinuous(int[] numbers) {
        int numOfZero = 0;
        int numOfInterval = 0;
        int length = numbers.length;
        if (length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length - 1; i++) {
            // 计算癞子数量
            if (numbers[i] == 0) {
                numOfZero++;
                continue;
            }
            // 对子，直接返回
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            numOfInterval += numbers[i + 1] - numbers[i] - 1;
        }
        //判断癞子是不是可以补足空缺部分
        if (numOfZero >= numOfInterval) {
            return true;
        }
        return false;
    }
}