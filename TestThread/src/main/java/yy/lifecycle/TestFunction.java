package yy.lifecycle;

/**
 * 常用方法：
 *  （1）start() :  启动当前线程，表面上调用start方法，实际在调用线程里面的run方法
 *  （2）run() : 线程类 继承 Thread类 或者 实现Runnable接口的时候，都要重新实现这个run方法，run方法里面是线程要执行的内容
 *  （3）currentThread :Thread类中一个静态方法：获取当前正在执行的线程
 *  （4）setName 设置线程名字
 *  （5）getName 读取线程名字
 */
public class TestFunction extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println(this.getPriority() + "====>" + i);
        }
    }

    /**
     * 同优先级的线程，采取的策略是先到先服务，使用时间片策略
     * 如果优先级别高，被CPU调度的概率就高，级别为1-10，默认的级别为5
     */
    public static void main(String[] args) {
        TestFunction t1 = new TestFunction();
        t1.setPriority(8);  // 设置优先级
        t1.start();
        TestFunction t2 = new TestFunction();
        t2.start(); // 默认为5
    }
}

