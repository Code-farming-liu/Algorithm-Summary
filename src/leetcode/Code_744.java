package leetcode;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 示例 2:
 * <p>
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 示例 3:
 * <p>
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= letters.length <= 104
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 */
public class Code_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    // 二分
    public char nextGreatestLetter1(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left] > target ? letters[left] : letters[0];
    }
}
