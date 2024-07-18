package yy.lifecycle;

/**
 * 设置伴随线程:
 *      将子线程设置为主线程的伴随线程，主线程停止的时候，子线程也不要继续执行了
 *  先设置，再调用start启动
 */
public class TestSetDaemonFunc extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(this.getName()+"===>"+i);
        }
    }

    public static void main(String[] args) {
        TestSetDaemonFunc t1 = new TestSetDaemonFunc();
        t1.setDaemon(true);
        t1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"===>"+i);
        }
    }
}
