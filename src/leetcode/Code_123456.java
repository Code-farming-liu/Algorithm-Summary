package leetcode;

import java.util.concurrent.*;

public class Code_123456 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                15,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println("total->" + countDownLatch.getCount());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        System.out.println(111111);
        System.out.println(111111);
        System.out.println(111111);
        System.out.println(111111);
        System.out.println(111111);
    }
}
