package yy.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁和synchronized的区别
 *  1.lock是显示锁，手动开始和关闭锁
 *  2.lock锁只有代码块锁，synchronized有代码块锁和方法锁
 *  3.使用lock锁，JVM将花费较少的时间来调度线程，性能更好
 *  使用顺序：
 *      lock--->同步代码块--->同步方法
 */
public class TestLock implements Runnable {
    int num = 10;
    Lock lock = new ReentrantLock();    // 获取锁

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 打开锁
            lock.lock();
            try {
                if (num > 0)
                    System.out.println(Thread.currentThread().getName() + "===" + num--);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TestLock t = new TestLock();
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();
        Thread t3 = new Thread(t);
        t3.start();
    }
}
