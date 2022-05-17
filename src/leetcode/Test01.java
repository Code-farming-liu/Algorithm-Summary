package leetcode;

/**
 * @ClassName: Test01
 * @Description: TODO
 * @Author: Admin
 * @Date 2021/9/15 21:32
 **/

public class Test01 {
//    private static int num;
//    private static final Object LOCK = new Object();
//
//    private static void printABC(int targetNum) {
//        for (int i = 0; i < 10; i++) {
//            synchronized (LOCK) {
//                while (num % 3 != targetNum) {
//                    try {
//                        LOCK.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                num++;
//                System.out.println(Thread.currentThread().getName());
//                LOCK.notifyAll();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new Thread(() -> {
//            printABC(0);
//        }, "A").start();
//
//        new Thread(() -> {
//            printABC(1);
//        }, "B").start();
//
//        new Thread(() -> {
//            printABC(2);
//        }, "C").start();
//    }
}