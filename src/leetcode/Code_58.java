package leetcode;

/**
 * @ClassName: Code_58
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/4/26 14:31
 **/

public class Code_58 {
    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" "));
    }
}