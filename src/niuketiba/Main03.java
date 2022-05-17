package niuketiba;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            String[] s1 = str1.split(" ");
            String[] s2 = str2.split(" ");
            for (int i = 0; i < n; i++) {
                nums1[i] = Integer.parseInt(s1[i]);
                nums2[i] = Integer.parseInt(s2[i]);
            }
            System.out.println("Yes");
            t--;
        }
    }
}
