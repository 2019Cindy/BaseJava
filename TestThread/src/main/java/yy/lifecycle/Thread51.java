package yy.lifecycle;

import java.util.Map;
import java.util.Random;

/**
 * 抢红包：
 * 假设：100块，分成了3个红包，现在5个人去抢。
 */
public class Thread51 {
    static int count = 3;
    static int money = 100;

    public static void main(String[] args) {
        RedEnvelope red = new RedEnvelope();
        for (int i = 0; i < 5; i++) {
            new Thread(red, i + "=====").start();
        }
    }

    static class RedEnvelope implements Runnable {
        int i = 0;
        double sum = 0;

        @Override
        public void run() {
            synchronized (RedEnvelope.class) {
                if (i == 5) {
                    return;
                } else if (i >= count) {
                    System.out.println(Thread.currentThread().getName() + "没抢到红包！");
                } else if (i == count - 1) {
                    double num = money - sum;
                    System.out.println(Thread.currentThread().getName() + "抢到了 " + String.format("%.2f",num) + " 元");
                } else {
                    double random = Math.random();
                    double num = Double.parseDouble(String.format("%.2f", random * (money - sum)));
                    sum += num;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了 " + num + " 元");
                }
                i++;
            }
        }
    }
}
