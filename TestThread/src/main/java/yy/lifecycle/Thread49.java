package yy.lifecycle;

/**
 * 有100份礼品，两人同时发送，当剩下的礼品小于10份时则不再送出。
 * 利用多线程模拟该过程，并将线程的名字和礼物的剩余数量打印出来
 */
public class Thread49 {
    static int sum = 100;

    public static void main(String[] args) {
        GiftThread gift = new GiftThread();
        new Thread(gift, "11111").start();
        new Thread(gift, "22222").start();
    }

    static class GiftThread implements Runnable {
        int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (GiftThread.class) {
                    if (count > sum - 10) {
                        System.out.println("剩余" + (sum - count) + "份礼物，已停止发放！");
                        return;
                    }
                    count++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在发放第" + count + "份礼物，还剩" + (sum - count) + "份礼物！");
                }
            }
        }
    }
}
