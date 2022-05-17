package zhenti.tengxun;

import java.util.LinkedList;
import java.util.*;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            LinkedList<Integer> queue = new LinkedList<>();
            long q = scanner.nextLong();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < q + 1; i++) {
                list.add(scanner.nextLine());
            }
            for (String str : list) {
                operation(queue, str);
            }
            t--;
        }
    }


    public static void operation(LinkedList<Integer> queue, String operation) {
        if (operation.startsWith("PUSH")) {
            queue.offerLast(Integer.parseInt(operation.split(" ")[1]));
        } else if (operation.equals("TOP")) {
            if (queue.size() > 0) {
                Integer peek = queue.peekFirst();
                System.out.println(peek);
            } else {
                System.out.println(-1);
            }
        } else if (operation.equals("POP")) {
            if (queue.size() > 0) {
                queue.pollFirst();
            } else {
                System.out.println(-1);
            }
        } else if (operation.equals("SIZE")) {
            System.out.println(queue.size());
        } else if (operation.equals("CLEAR")) {
            queue.clear();
        }
    }

}
