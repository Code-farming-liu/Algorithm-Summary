package leetcode;


public class Code_917 {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = n - 1; i < j; ) {
            while (i < j && !Character.isLetter(cs[i])) i++;
            while (i < j && !Character.isLetter(cs[j])) j--;
            if (i < j) {
                char c = cs[i];
                cs[i++] = cs[j];
                cs[j--] = c;
            }
        }
        return String.valueOf(cs);
    }


    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
