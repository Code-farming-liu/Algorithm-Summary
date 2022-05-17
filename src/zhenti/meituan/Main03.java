package zhenti.meituan;


import java.io.*;
import java.util.*;

public class Main03 {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            String tables = reader.readLine();
            int M = Integer.parseInt(reader.readLine());
            String enters = reader.readLine();

            int[] res = solve(tables, enters);
            for (int r : res) {
                writer.write(Integer.toString(r));
                writer.newLine();
            }
        }
        writer.flush();
    }

    private static int[] solve(String tables, String enters) {
        List<PriorityQueue<Integer>> pqs = new ArrayList<>(3);
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        for (int i = 0; i < tables.length(); i++) {
            pqs.get(tables.charAt(i) - '0').add(i);
        }
        int[] res = new int[enters.length()];
        for (int i = 0; i < enters.length(); i++) {
            int table;
            if (enters.charAt(i) == 'M') {
                if (pqs.get(1).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            } else {
                if (!pqs.get(0).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            res[i] = table + 1;
        }

        return res;
    }

}