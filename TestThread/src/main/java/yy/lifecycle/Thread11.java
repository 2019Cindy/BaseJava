package yy.lifecycle;

public class Thread11 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            t1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("t2");
                    }
                });
        Thread t3 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            t2.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("t3");

                    }
                });
        t3.start();
        t2.start();
        t1.start();
    }
}
