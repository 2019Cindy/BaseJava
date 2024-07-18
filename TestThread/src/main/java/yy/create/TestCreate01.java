package yy.create;

/**
 * 创建线程的方法一：继承Thread类
 * 通过getName setName方法获取线程名
 * 通过构造器设置名字
 */
public class TestCreate01 extends Thread{
    public TestCreate01(){}
    // 通过构造器设置名字
    public TestCreate01(String name) {
        super(name);    // 调用父类的有参构造器
    }
    /**
     * 必须重写thread类中的run方法，线程的任务/逻辑 写在run方法中
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            System.out.println(this.getName()+"==========="+i);
            System.out.println(Thread.currentThread().getName()+"--------------"+i);
        }
    }

    public static void main(String[] args) {
        System.out.println("当前线程名："+Thread.currentThread().getName());
        // 创造其他线程，进行资源争夺
        TestCreate01 thread01 = new TestCreate01();
        thread01.setName("哈哈哈");
        thread01.start();   // start方法是thread类中的方法，启动线程进行资源抢夺
//        thread01.run();   // 调用run方法，执行线程中的任务。run方法不能直接调用，直接调用就会被当作一个普通方法
        TestCreate01 thread02 = new TestCreate01("aaaaa2");
        thread02.start();
//        thread02.run();


        // 主线程输出
        for (int i = 0; i < 10; i++) {
            System.out.println("main============"+i);
        }
    }
}
