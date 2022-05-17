package zhenti.tengxun;

import java.util.*;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        Set<String> set = new HashSet<>();
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < str.length(); j++) {
                String substring = str.substring(j, i + j);
                if (!set.contains(substring)) {
                    if (queue.size() < k) {
                        queue.offer(substring);
                    } else {
                        if (substring.compareTo(queue.peek()) < 0) {
                            queue.poll();
                            queue.offer(substring);
                        }
                    }
                    set.add(substring);
                }
            }
        }
        System.out.println(queue.peek());
    }
}
