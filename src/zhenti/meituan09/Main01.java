package zhenti.meituan09;


import java.io.*;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String[] split = s1.split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int a = Integer.parseInt(split[2]);
            int b = Integer.parseInt(split[3]);
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            String s2 = scanner.nextLine();
            String[] split1 = s2.split(" ");
            boolean aFlag = false, bFlag = false;
            int min = 1001, max = -1;
            for (String s : split1) {
                int num = Integer.parseInt(s);
                if (num == a) {
                    aFlag = true;
                }
                if (num == b) {
                    bFlag = true;
                }
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            if (min < a || max > b) {
                System.out.println("NO");
                continue;
            }
            if (aFlag && bFlag) {
                System.out.println("YES");
                continue;
            }
            if (aFlag || bFlag) {
                if (n - m > 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                continue;
            }
            System.out.println(n - m > 1 ? "YES" : "NO");
        }
    }
}
