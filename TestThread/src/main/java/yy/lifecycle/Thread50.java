package yy.lifecycle;

/**
 * 同时开启两个线程，共同获取1-100之间的所有数字，输出所有的奇数
 */
public class Thread50 {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number,"1111").start();
        new Thread(number,"22222").start();
    }

    static class Number implements Runnable {
        int i = 1;

        @Override
        public void run() {
            while (true) {
                synchronized (Number.class) {
                    if (i > 100) {
                        System.out.println("数据获取完毕！");
                        return;
                    }
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "获取数字：" + i);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }
    }
}
