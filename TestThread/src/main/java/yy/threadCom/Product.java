package yy.threadCom;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信：生产者
 */
public class Product {
    private String brand;
    private String name;
    // 信号灯,true为有商品，false为没有商品
    boolean flag = false;
    // lock锁
    ReentrantLock lock = new ReentrantLock();
    //生成者等待队列
    Condition proCondition = lock.newCondition();
    Condition cusCondition = lock.newCondition();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Java对象中，有两种池
     *  锁池：synchronized
     *  等待池：wait()、notify()、notifyAll()
     *  原理：如果一个线程调用了某个对象的wait方法，该线程进入到该对象的等待池中，并且将锁释放
     *  如果在未来的某一个刻，另一个线程调用了相同对象的notify或notifyAll方法，该等待池中的线程就会被唤醒，
     *  进入到对象的锁池中获取该对象的锁，如果获得锁成功后，该线程就会沿着wait方法之后的路径继续执行。
     *
     *  注意：1.wait方法和notify方法  是必须放在同步方法或者同步代码块中才生效的 （因为在同步的基础上进行线程的通信才是有效的）
     *       2.sleep和wait的区别：sleep进入阻塞状态没有释放锁，wait进入阻塞状态但是同时释放了锁
     */
    public synchronized void setProduct(String brand, String name) {
        if (flag) {  // 有商品，等待消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 没有商品，开始生成
        this.setBrand(brand);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setName(name);
        System.out.println("生产者生产了" + this.getBrand() + "===" + this.getName());

        // 生产完成后，变为true
        flag = true;
        notify();   // 告诉消费者来进行消费
    }

    public synchronized void getProduct() {
        if (!flag) {    // 没有商品，进行等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 消费
        System.out.println("消费者消费了" + this.getBrand() + "===" + this.getName());
        flag = false;   // 消费完后，变为false
        notify();   // 通知生产者
    }

    /**
     * Condition是在Java 1.5中才出现的，它用来替代传统的Object的wait()、notify()实现线程间的协作，
     * 相比使用Object的wait()、notify()，使用Condition1的await()、signal()这种方式实现线程间协作更加安全和高效。
     * 它的更强大的地方在于：能够更加精细的控制多线程的休眠与唤醒。对于同一个锁，我们可以创建多个Condition，在不同的情况下使用不同的Condition
     * 一个Condition包含一个等待队列。一个Lock可以产生多个Condition，所以可以有多个等待队列。
     *
     * lock锁和sync同步锁的区别：
     *  1.Object中的wait(),notify(),notifyAll()方法是和"同步锁"(synchronized关键字)捆绑使用的
     *  2.Condition是需要与"互斥锁"/"共享锁"捆绑使用的
     *  3.Condition的await()、signal()、signalAll()方法，都必须在lock保护之内，就是说必须在lock.lock()和lock.unlock之间才可以使用
     *      · Conditon中的await()对应Object的wait()；
     *      · Condition中的signal()对应Object的notify()；
     *      · Condition中的signalAll()对应Object的notifyAll()。
     */
    public void setProductLock(String brand, String name) {
        lock.lock();    // 开锁
        try {
            if (flag) { // 有商品，进入等待队列
                try {
//                    this.wait();  和sync才有效
                    proCondition.await();   // 生产者进入等待队列中
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 没有商品，开始生产
            this.setBrand(brand);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setName(name);
            System.out.println("生产者生产了" + this.getBrand() + "===" + this.getName());
            // 生产完后，修改标记
            this.flag = true;
//            notify();   // 通知消费者
            cusCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getProductLock(){
        if (!flag) {
            try {
                cusCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者消费了" + this.getBrand() + "===" + this.getName());
        flag = false;
        proCondition.signal();
    }
}
