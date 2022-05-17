package zhenti.zijie;

public class Main01 {
    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        int k = 2;
        int[] nums = {1,0,0,1,1};
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (index > -1) {
                    if (i - index - 1 < k) {
                        System.out.println(0);
                        return;
                    }
                }
                index = i;
            }
        }
        System.out.println(index == -1 ? 0 : 1);
    }
}
