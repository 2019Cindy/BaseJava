package yy.lifecycle;


public class Thread47 {
    public static void main(String[] args) {
        Product p = new Product();
        Consumer c = new Consumer();
        new Thread(p, "生产者").start();
        new Thread(c, "消费者").start();
    }

    static class Product implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Desk.lock) {
                    if (Desk.count == 0) {
                        System.out.println("今日生产量已达标！");
                        return;
                    }
                    if (Desk.flag == 1) {   // 有食物，通知消费者
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Desk.count--;
                        System.out.println("正在生产，还需要生产" + Desk.count + "份！");
                        Desk.flag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Desk.lock) {
                    if (Desk.count == 0) {
                        System.out.println("已经吃了10份，不能再吃了！");
                        return;
                    }
                    if (Desk.flag == 0) {   // 没有食物，通知生产者，等待
                        try {
                            Desk.lock.wait();   // 让当前线程与锁进行绑定
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        Desk.lock.notify(); // 唤醒该锁下绑定的线程
                    } else {  // 有食物，消费食物，修改标记,通知生产者
                        Desk.flag = 0;
                        Desk.count--;
                        System.out.println("正在消费，最多还能消费" + Desk.count + "份。。。");
                        Desk.lock.notify();
                    }
                }
            }
        }
    }

    static class Desk {
        // 0:没有食物，1：有食物
        static int flag = 0;
        // 食物个数
        static int count = 10;
        // 锁对象
        static Object lock = new Object();
    }

}
