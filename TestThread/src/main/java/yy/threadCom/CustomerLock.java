package yy.threadCom;

public class CustomerLock extends Thread {
    private Product p;

    public CustomerLock(Product p) {
        this.p = p;
    }
}
