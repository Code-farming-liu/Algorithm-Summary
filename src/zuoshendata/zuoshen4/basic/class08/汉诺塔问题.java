package zuoshendata.zuoshen4.basic.class08;

/**
 * @ClassName: 汉诺塔问题
 * @Description: TODO
 * @Author: Admin
 * @Date 2020/12/8 20:57
 **/

public class 汉诺塔问题 {
    public static void process(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to" + to);
            return;
        } else {
            process(N - 1, from, help, to);
            System.out.println("Move " + N + " from " + from + " to" + to);
            process(N - 1, help, to, from);
        }
    }

    //尝试
    public static void moveLeftToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to right");
        } else {
            //将N - 1移动到 mid
            moveLeftToMid(N - 1);
            System.out.println("move " + N + " from left to right");
            moveMidToRight(N - 1);
        }
    }

    private static void moveMidToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from mid to right");
        } else {
            moveMidToLeft(N - 1);
            System.out.println("move " + N + " from mid to right");
            moveLeftToRight(N - 1);
        }
    }

    private static void moveMidToLeft(int N) {
        if (N == 1) {
            System.out.println("move 1 from mid to left");
        } else {
            moveMidToRight(N - 1);
            System.out.println("move " + N + " from mid to right");
            moveRightToLeft(N - 1);
        }
    }

    private static void moveRightToLeft(int N) {
        if (N == 1) {
            System.out.println("move 1 from right to left");
        } else {
            moveRightToMid(N - 1);
            System.out.println("move " + N + " from right to left");
            moveMidToLeft(N - 1);
        }
    }

    private static void moveRightToMid(int N) {
        if (N == 1) {
            System.out.println("move 1 from right to mid");
        } else {
            moveRightToLeft(N - 1);
            System.out.println("move " + N + " from right to mid");
            moveLeftToMid(N - 1);
        }
    }

    private static void moveLeftToMid(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to mid");
        } else {
            //将N - 1移动到 mid
            moveLeftToRight(N - 1);
            System.out.println("move " + N + " from left to mid");
            moveRightToMid(N - 1);
        }
    }

    public static void main(String[] args) {
        process(3, "左", "右" , "中");
        moveLeftToRight(3);
    }
}