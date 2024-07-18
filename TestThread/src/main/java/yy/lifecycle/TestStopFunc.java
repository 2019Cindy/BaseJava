package yy.lifecycle;

/**
 * stop:线程停止，过期方法，不建议使用
 */
public class TestStopFunc {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if(i==5)
                Thread.currentThread().stop();
            System.out.println(Thread.currentThread().getName()+"===>"+i);
        }
    }
}
