package yy.create;

/**
 * 比较：
 *      方式一：继承Thread类，Java有单继承的局限性，继承了Thread类就不能再继承其他的类
 *      方式二：实现runnable接口，共享资源的能力会好一些，不需要用static修饰属性
 * 联系：
 *
 */

public class BuyTicketThread02 implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (num > 0)
                System.out.println(Thread.currentThread().getName() + "买到了第" + num-- + "票");
        }
    }

    public static void main(String[] args) {
        BuyTicketThread02 ticket = new BuyTicketThread02();
        Thread t1 = new Thread(ticket);
        t1.setName("窗口1");
        t1.start();
        Thread t2 = new Thread(ticket);
        t2.setName("窗口2");
        t2.start();
        Thread t3 = new Thread(ticket,"窗口3");
        t3.start();

    }
}
