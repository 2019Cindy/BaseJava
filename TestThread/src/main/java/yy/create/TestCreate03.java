package yy.create;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 对比第一种和第二种创建线程的方式发现，无论是第一种继承Thread方法还是实现Runnable接口，都需要重写run方法，但是run方法有不足之处
 *  （1）没有返回值
 *  （2）不能抛出异常
 *  第三种方式：实现Callable接口
 *  好处：有返回值，可以抛出异常
 *  缺点：线程创建比较麻烦
 */
public class TestCreate03 implements Callable<Integer> {
    /**
     * 实现Callable接口，可以不带泛型，若不带泛型，call方法的返回值就是Object类型
     * 若带泛型，那么call的返回值类型就是泛型对应的类型
     * 从call方法可以看到，方法有返回值，可以抛出异常
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);    // 10以内的随机数
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCreate03 testCreate03 = new TestCreate03();
        FutureTask ft = new FutureTask(testCreate03);
        Thread thread = new Thread(ft);
        thread.start();
        // 获取线程的返回值
        Object res = ft.get();
        System.out.println(res);
    }
}
