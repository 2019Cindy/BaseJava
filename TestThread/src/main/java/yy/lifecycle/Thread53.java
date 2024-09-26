package yy.lifecycle;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class Thread53 {
    public static void main(String[] args) {
        // 获取现称此对象
        // 创建一个没有上线的线程池
//        ExecutorService pool = Executors.newCachedThreadPool();
        // 创建一个有上限的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 提交任务
        pool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "=====" + i);
                }
            }
        });
        // 关闭线程池
        pool.shutdown();
    }
}

// 自定义线程池
class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    }
}
