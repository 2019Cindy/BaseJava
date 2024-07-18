package yy.create;

/**
 * 创建线程的方法一：实现Runnable接口
 */
public class TestThread02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "====" + i);
        }
    }

    public static void main(String[] args) {
        TestThread02 thread = new TestThread02();
        Thread t = new Thread(thread,"haha");
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"==="+i);
        }
    }
}
