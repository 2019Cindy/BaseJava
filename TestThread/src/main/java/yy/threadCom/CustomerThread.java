package yy.threadCom;

public class CustomerThread implements Runnable {
    private Product p;  // 共享商品

    public CustomerThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (p) {
                System.out.println("消费者消费了" + p.getBrand() + "===" + p.getName());
            }
        }
    }

}
