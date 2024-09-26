package yy.lifecycle;

public class Thread45 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.setName("女神");
        t2.setName("备胎");
        t2.setDaemon(true); // 设置为守护线程
        t1.start();
        t2.start();
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() + "========>" + i);
            }
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(this.getName() + "===>" + i);
            }
        }
    }
}
