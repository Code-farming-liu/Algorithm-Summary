package zuoshendata.zuoshen4.basic.class07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: 安排场次多
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/18 14:17
 **/

public class 安排场次多 {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}