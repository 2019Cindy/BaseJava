package yy.lifecycle;

/**
 *join方法：当一个线程调用了join方法，这个线程就会被先执行，它执行结束后才可以去执行其余的线程
 * 注意：必须先start，再join才有效
 */
public class TestJoinFunc extends Thread {
    public TestJoinFunc(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + "===>" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            if (i == 5) {
                TestJoinFunc t1 = new TestJoinFunc("子线程");
                t1.start();
                t1.join();  // "程咬金"
            }
            System.out.println(Thread.currentThread().getName() + "===>" + i);
        }

    }
}
