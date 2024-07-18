package yy.sync;

/**
 * 同步监视器：synchronized(同步监视器){}
 *      1.必须是引用数据类型，不能是基本数据类型
 *      2.可以创建一个专门的同步监视器，没有任何业务含义
 *      3.一般使用共享资源做同步监视器即可
 *      4.在同步代码块中，不能改变同步监视器对象的引用
 *      5.尽量不要使用String和包装类Integer做同步监视器，值会发生修改
 *      6.建议使用final修饰同步监视器
 *  同步代码块的执行过程
 *      1.第一个线程来到同步代码块，发现同步监视器open状态，需要close，然后执行其中的代码
 *      2.第一个线程执行过程中，发生了线程切换（阻塞 就绪），第一个线程失去CPU，但是没有开锁open
 *      3.第二个线程获取cpu，来到同步代码块，发现同步监视器close状态，无法执行其中的代码，第二个线程也进入阻塞状态
 *      4.第一个线程再次获取cpu，执行后续代码，同步代码块执行完毕，释放锁open
 *      5.第二个线程再次获取cpu，来到同步代码块，发现同步监视器open状态，拿到锁并上锁，由阻塞状态进入就绪状态，在进入运行状态，除父线程一的处理过程
 *      注意：同步代码块中能发生CPU的切换吗？能，但是后续被执行的线程将无法执行同步代码块，因为锁close
 *
 */
public class TestSyncBlock02 extends Thread {
    static int num = 10;
    static Object o =new Object();
    final String str="this";    // 使用final修饰同步监视器

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            synchronized (this) // 多个对象，此处的this不是同一把锁
//            synchronized (o)  // 创建一个专门的同步监视器，没有任何业务含义
//            synchronized (str)
            synchronized (TestSyncBlock02.class) {  // 一般使用共享资源做同步监视器
                if (num > 0)
                    System.out.println(this.getName() + " 第" + num-- + "票");
            }
        }
    }

    public static void main(String[] args) {
        TestSyncBlock02 t1 = new TestSyncBlock02();
        t1.start();
        TestSyncBlock02 t2 = new TestSyncBlock02();
        t2.start();
    }
}
