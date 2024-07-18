package yy.threadCom;

/**
 * 生产者线程
 */
public class ProducerThread implements Runnable {
    private Product p ;

    public ProducerThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (p) {  // 同步代码块
                if (i % 2 == 0) {
                    p.setBrand("费列罗");
                    p.setName("巧克力");
                } else {
                    p.setBrand("哈尔冰");
                    p.setName("啤酒");
                }
                System.out.println("生产者生成了" + p.getBrand() + "====" + p.getName());
            }
        }
    }
}
