package yy.threadCom;

public class Test {
    public static void main(String[] args) {
        Product p = new Product();
//        ProducerThread pt = new ProducerThread(p);
//        CustomerThread ct = new CustomerThread(p);
//        new Thread(pt).start();
//        new Thread(ct).start();

        System.out.println("===============同步方法===============");
        ProductSyncThread pt = new ProductSyncThread(p);
        CustomerSyncThread ct = new CustomerSyncThread(p);
        pt.start();
        ct.start();
    }
}
