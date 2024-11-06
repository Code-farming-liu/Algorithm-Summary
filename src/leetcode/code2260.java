package leetcode;


import java.util.HashMap;
import java.util.Map;

/*
*给你一个整数数组 cards ，其中 cards[i] 表示第 i 张卡牌的 值 。如果两张卡牌的值相同，则认为这一对卡牌 匹配 。

返回你必须拿起的最小连续卡牌数，以使在拿起的卡牌中有一对匹配的卡牌。如果无法得到一对匹配的卡牌，返回 -1 。

示例 1：

输入：cards = [3,4,2,3,4,7]
输出：4
解释：拿起卡牌 [3,4,2,3] 将会包含一对值为 3 的匹配卡牌。注意，拿起 [4,2,3,4] 也是最优方案。
示例 2：

输入：cards = [1,0,5,3]
输出：-1
解释：无法找出含一对匹配卡牌的一组连续卡牌。

提示：

1 <= cards.length <= 105
0 <= cards[i] <= 106
*/
public class code2260 {
    public int minimumCardPickup1(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = cards.length;
        int res = len;
        int right = -1;
        boolean pass = true;

        for (int left = 0; left < len; left++) {
            if (left != 0) {
                map.remove(cards[left - 1]);
            }

            while (right + 1 < len && !map.containsKey(cards[right + 1])) {
                map.put(cards[right + 1], right + 1);
                right++;
            }

            if (right + 1 >= len && pass) {
                return -1;
            }

            if (right + 1 >= len) {
                return res;
            }

            if (pass) {
                pass = false;
            }
            Integer val = map.get(cards[right + 1]);
            if (val != null) {
                res = Math.min(res, right - val + 2);
            }
        }

        return res;
    }


    public int minimumCardPickup(int[] cards) {
        int minCards = Integer.MAX_VALUE;
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int length = cards.length;
        for (int i = 0; i < length; i++) {
            int card = cards[i];
            if (indices.containsKey(card)) {
                int size = i - indices.get(card) + 1;
                minCards = Math.min(minCards, size);
            }
            indices.put(card, i);
        }
        return minCards < Integer.MAX_VALUE ? minCards : -1;
    }
}
