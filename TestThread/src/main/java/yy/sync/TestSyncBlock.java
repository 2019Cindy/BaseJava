package yy.sync;

public class TestSyncBlock implements Runnable {
    int num = 10;

    public static void main(String[] args) {
        TestSyncBlock t = new TestSyncBlock();      // 同一个对象，一把锁
        Thread t1 = new Thread(t);

        Thread t2 = new Thread(t);
        t2.start();
        t1.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {   // 把具有安全隐患的代码锁住即可，如果锁多了，就会出现效率低 ====》 this为这个锁
                if (num > 0)
                    System.out.println(Thread.currentThread().getName() + " 第" + num-- + "票");
            }
        }
    }
}
