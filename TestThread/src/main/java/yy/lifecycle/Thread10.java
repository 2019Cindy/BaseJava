package yy.lifecycle;

import java.util.concurrent.locks.ReentrantLock;

public class Thread10 implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        System.out.println("lock....");
        try {
            System.out.println("hhh");
        } finally {
            lock.unlock();
            System.out.println("unlock....");
        }
    }

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        new Thread(thread10).start();
    }
}
