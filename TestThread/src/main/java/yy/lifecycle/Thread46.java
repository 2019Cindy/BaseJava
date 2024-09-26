package yy.lifecycle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求：某电影院正在上映国产大片，共100张票，有3个窗口售卖，设计一个程序模拟卖票
 */
public class Thread46 {
    static int num = 100;

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
//        new Thread(tickets, "111").start();
//        new Thread(tickets, "222").start();
//        new Thread(tickets, "333").start();

        Tickets1 tickets1 = new Tickets1();
//        new Thread(tickets1, "===111").start();
//        new Thread(tickets1, "===222").start();
//        new Thread(tickets1, "===333").start();

        Tickets2 tickets2 = new Tickets2();
        new Thread(tickets2, "----111").start();
        new Thread(tickets2, "----222").start();
        new Thread(tickets2, "----333").start();

    }

    static class Tickets implements Runnable {
        static int count = 0;
        // 锁对象，一定要是唯一的
        static Object o = new Object();

        @Override
        public void run() {
            while (true) {
                // 同步代码块实现
                synchronized (o) {
                    if (count >= 100) {
                        System.out.println("票已售罄！");
                        return;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    num--;
                    System.out.println(Thread.currentThread().getName() + "当前正在售卖第" + count + "票，还剩" + num + "张票");

                }
            }
        }
    }

    /**
     * 同步方法实现
     */
    static class Tickets1 implements Runnable {
        int count = 0;

        @Override
        public void run() {
            while (true) {
                if (!buyTickets()) break;
            }
        }

        private synchronized boolean buyTickets() {
            if (count >= 100) {
                System.out.println("票已售罄！");
                return false;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            num--;
            System.out.println(Thread.currentThread().getName() + "当前正在售卖第" + count + "票，还剩" + num + "张票");
            return true;
        }
    }

    /**
     * lock锁实现
     */
    static class Tickets2 implements Runnable {
        Lock lock = new ReentrantLock();
        int count;

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (count >= 100) {
                        System.out.println("售罄！");
                        return;
                    }
                    count++;
                    num--;
                    System.out.println(Thread.currentThread().getName() + "正在销售第" + count + "张票，还剩" + num + "张票");
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
