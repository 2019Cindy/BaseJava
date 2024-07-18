package yy.create;

public class BuyTicketThread extends Thread {
    static int num = 10; // 一共10张票，多个对象共享

    public BuyTicketThread(){

    }
    public BuyTicketThread(String name){
        super(name);
    }
    @Override
    public void run() {
        // 每个窗口都有100人在抢票
        for (int i = 0; i < 50; i++) {
            if(num>0)
                System.out.println("在"+Thread.currentThread().getName()+"买到了第" + num-- + "张车票");
        }
    }

    public static void main(String[] args) {
        // 多个窗口抢票
        BuyTicketThread t1 = new BuyTicketThread();
        t1.setName("t1窗口");
        t1.start();
        BuyTicketThread t2 = new BuyTicketThread();
        t2.setName("t2窗口");
        t2.start();
        BuyTicketThread t3 = new BuyTicketThread("t3窗口");
//        t1.setName("t3窗口");
        t3.start();
    }
}

