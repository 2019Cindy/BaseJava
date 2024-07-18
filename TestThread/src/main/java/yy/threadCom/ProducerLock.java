package yy.threadCom;

public class ProducerLock extends Thread {
    private Product p;

    public ProducerLock(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {

            } else {

            }
        }
    }
}
