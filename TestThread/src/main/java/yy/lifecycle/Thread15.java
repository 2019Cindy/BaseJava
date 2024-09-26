package yy.lifecycle;

import java.util.concurrent.*;

public class Thread15 {
    public static void main(String[] args) {
        int core=5;
        int maxPoolSize=10;
        long time=5000;
        TimeUnit unit=TimeUnit.SECONDS;
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(50);
        ThreadFactory factory = Executors.defaultThreadFactory();
        ThreadPoolExecutor.AbortPolicy policy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(core, maxPoolSize, time, unit, queue, factory, policy);
        for (int i = 0; i < 20; i++) {
            executor.submit(()->{
                System.out.println("hhhhh...");
            });
        }
    }
}
