package yy.sync;

public class TestSyncFunc2 implements Runnable{
    int num = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            buyTickets();
        }
    }

    // 同步方法
    public synchronized void buyTickets() { // 锁住的是this，当前对象
        if (num > 0)
            System.out.println(Thread.currentThread().getName() + "===>第" + num-- + "票");
    }

    public static void main(String[] args) {
        TestSyncFunc2 t = new TestSyncFunc2();
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();
        Thread t3 = new Thread(t);
        t3.start();
    }
}
