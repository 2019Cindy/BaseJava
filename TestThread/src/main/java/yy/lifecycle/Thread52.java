package yy.lifecycle;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有一个抽奖池，该抽奖池中存放了奖励的全部金额，该抽奖池中的奖项为{10，5，20，50，100，200，500，800，2，80，300，700}
 * 创建两个抽奖箱，随机从抽奖池中获取奖项元素并打印在控制台上
 * <p>
 * 再以上基础上，继续完成：每次抽奖的过程中不打印，抽完时一次性打印，抽奖箱1 2中分别共产生6个奖项
 * <p>
 * 在以上基础上继续完成：此次抽奖过程中的最大奖项
 */
public class Thread52 {
    static int[] nums = {10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700};
    static List<Integer> lists = Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700);


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));
//        Lottery lottery = new Lottery(list);

//        Lottery2 lottery = new Lottery2(list);
//        new Thread(lottery, "11111").start();
//        new Thread(lottery, "222").start();

        Lottery3 lottery3 = new Lottery3(list);
        FutureTask<Integer> task1 = new FutureTask<Integer>(lottery3);
        Thread thread = new Thread(task1,"111111");
        thread.start();
        FutureTask<Integer> task2 = new FutureTask<Integer>(lottery3);
        Thread thread2 = new Thread(task2,"2222222");
        thread2.start();

        try {
            Integer i1 = task1.get();
            Integer i2 = task2.get();
            if (i1 > i2)
                System.out.println(thread.getName() + "中产生了最大奖项，奖金金额为" + i1 + "元");
            else
                System.out.println(thread2.getName() + "中产生了最大奖项，奖金金额为" + i2 + "元");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class Lottery implements Runnable {
        ArrayList list;

        public Lottery(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (Lottery.class) {
                    if (list.size() == 0) {
                        System.out.println("抽奖已结束！");
                        return;
                    }
                    double random = Math.random();
                    int index = (int) Math.floor(random * list.size());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "又产生了一个" + list.get(index) + " 元大奖！");
                    list.remove(index);
                }
//                if (getLuckNumber(list))
//                    return;
            }
        }

        private synchronized boolean getLuckNumber(ArrayList list) {
            if (list.size() == 0) {
                System.out.println("抽奖已结束！");
                return true;
            }
            double random = Math.random();
            int index = (int) Math.floor(random * list.size());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "又产生了一个" + list.get(index) + " 元大奖！");
            list.remove(index);
            return false;
        }
//        @Override
//        public void run() {
//            while (true) {
//                double random = Math.random();
//                int index = (int) Math.floor(random * nums.length);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + "又产生了一个" + nums[index] + " 元大奖！");
//            }
//        }
    }

    static class Lottery2 implements Runnable {
        ArrayList list;

        public Lottery2(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            int count = 0;
            int sum = 0;
            ArrayList<Integer> res = new ArrayList<>();
            while (true) {
                if (count == 6) {
                    System.out.println(Thread.currentThread().getName() + "抽奖结束,奖项分别为" + res.toString() + ",最大金额为："
                            + Collections.max(res) + ",总金额为：" + sum);
                    return;
                }
                double random = Math.random();
                int index = (int) Math.floor(random * list.size());
                int price = (int) list.remove(index);
                sum += price;
                res.add(price);
                count++;
            }
        }
    }

    // 返回当前线程的最大值
    static class Lottery3 implements Callable {
        ArrayList<Integer> list;

        public Lottery3(ArrayList list) {
            this.list = list;
        }

        @Override
        public Integer call() throws Exception {
            int max = 0;
            synchronized (Lottery3.class) {
                for (int i = 0; i < 6; i++) {
                    double random = Math.random();
                    int index = (int) Math.floor(random * list.size());
                    max = max > list.get(index) ? max : list.get(index);
                    Thread.sleep(200);
                    list.remove(index);
                }
                return max;
            }
        }
    }
}
