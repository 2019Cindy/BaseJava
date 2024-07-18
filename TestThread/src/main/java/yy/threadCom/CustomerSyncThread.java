package yy.threadCom;

public class CustomerSyncThread extends Thread {
    private Product p;

    public CustomerSyncThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            p.getProduct();
        }
    }
}
