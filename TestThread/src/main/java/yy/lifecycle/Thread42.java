package yy.lifecycle;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread42 implements Callable {
    int count;

    public Thread42(int count) {
        this.count = count;
    }

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            count += 10;
        }
        return Thread.currentThread().getName() + " 结果为：" + count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread42 t = new Thread42(i * 100);
            FutureTask<Object> future = new FutureTask<Object>(t);
            Thread thread = new Thread(future);
            thread.start();
            try {
                String o = (String) future.get();
                System.out.println(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
