package yy.lifecycle;

public class Thread9 extends Thread {
    volatile boolean stop = false;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                stop=true;
                Thread.interrupted();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread9 t = new Thread9();
        System.out.println("start...");
        t.start();
        Thread.sleep(2000);     // 主线程等待
        t.interrupt();
        System.out.println("end....");
    }
}
