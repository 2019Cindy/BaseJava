package yy.lifecycle;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列实现生产者-消费者
 */
public class Thread48 {
    public static void main(String[] args) {
        // 阻塞队列
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
        Product p = new Product(queue);
        Consumer c = new Consumer(queue);
        p.setName("ppp");
        c.setName("ccc");
        p.start();
        c.start();
    }

    static class Product extends Thread {
        ArrayBlockingQueue<String> queue;

        public Product(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    queue.put("商品");
                    System.out.println("生产一件商品。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        ArrayBlockingQueue<String> queue;

        public Consumer(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String take = queue.take();
                    System.out.println("消费一个商品，" + take + "。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
