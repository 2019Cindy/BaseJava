package yy.sync;

/**
 * 同步方法：
 *  1.不要将run()定义同步方法，锁住的内容过多，效率低
 *  2.非静态同步方法的同步监视器为this，静态同步方法的同步监视器是 类名.class 字节码信息对象
 *  3.同步代码块的效率要高于同步方法，（同步方法锁住的内容过多），同步方法将线程挡在了方法外面，而同步代码块锁将线程挡在了代码块内部，方法的外部
 *  4.同步方法的锁是this，一旦锁住了一个方法，就锁住了所有的同步方法。同步代码块只是锁住使用改同步监视器的代码块，而没有锁住使用其他监视器的代码块
 */
public class TestSyncFunc extends Thread{
    static int num=10;
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            buyTickets();
        }
    }

    // 同步方法
//    public synchronized void buyTickets(){  // 当前有多个对象,锁住的this
    public static synchronized void buyTickets(){   // 使用static，锁住的是同步监视器： BuyTicketThread.class
        if (num > 0)
            System.out.println(Thread.currentThread().getName() + "===>第" + num-- + "票");
    }
    public static void main(String[] args) {
        TestSyncFunc t = new TestSyncFunc();
        t.start();
        TestSyncFunc t2 = new TestSyncFunc();
        t2.start();
    }
}
