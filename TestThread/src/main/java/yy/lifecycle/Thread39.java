package yy.lifecycle;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread39 implements Runnable {
    private int id;
    private CyclicBarrier barrier;

    public Thread39(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println("玩家" + id + "已到达！");
        try {
            Thread.sleep(1000);
            barrier.await(); // 等待所有玩家到齐
            System.out.println("玩家" + id + "开始游戏！");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int count = 5;
        CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("玩家均已到位，开始游戏！");
            }
        });
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(new Thread39(i, barrier));
            t.start();
        }
    }
}

class ThreadTest extends Thread {
    CyclicBarrier barrier;

    public ThreadTest(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(this.getName() + " 到达栅栏A点");
            barrier.await();
            System.out.println(this.getName() + " 冲刺A点");
            Thread.sleep(1000);
            System.out.println(this.getName() + " 到达B点");
            barrier.await();
            System.out.println(this.getName() + " 冲刺B点");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int count=5;
        CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("全员已到达，准备冲刺。。。。。");
            }
        });
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(new ThreadTest(barrier));
            t.start();
        }
    }
}
