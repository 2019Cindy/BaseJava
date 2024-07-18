package yy.threadCom;

public class ProductSyncThread extends Thread {
    private Product p;

    public ProductSyncThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0)
                p.setProduct("费雷罗", "巧克力");
            else
                p.setProduct("哈尔滨", "啤酒");
        }
    }
}
