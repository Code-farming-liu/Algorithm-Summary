package niuketiba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        String str = scanner.nextLine();
        int n = 8;
        String str = "CCCCJJJJ";
        int a = 0, b = 0;
        List<Integer> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                i++;
            }
            if (i - j > 0) {
                list.add(i - j + 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'C') {
                a++;
            } else {
                b++;
            }
        }
        if (a > b + 1 || b > a + 1) {
            System.out.println(-1);
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i) / 2;
        }
        System.out.println(count / 2);
    }
}
