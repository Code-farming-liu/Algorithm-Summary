package zhenti.meituan09;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
        }
//        int n = 5, x = 5;
//        int[] score = {0, 2, 1, 1, 1};
        int count = 0;
        Arrays.sort(score);
        if (n < x) {
            for (int i = 0; i < n; i++) {
                if (score[i] > 0) {
                    count++;
                }
            }
            System.out.println(count);
            return;
        }
        int a = score[n - x];
        for (int i = 0; i < n; i++) {
            if (score[i] > 0 && a <= score[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
