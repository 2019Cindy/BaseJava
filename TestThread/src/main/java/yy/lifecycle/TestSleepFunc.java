package yy.lifecycle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  sleep：人为的制造阻塞事件
 */
public class TestSleepFunc {
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(5000);
//        System.out.println("嗷呜嗷呜");
        while (true) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            System.out.println(format.format(date));
            Thread.sleep(1000);
        }
    }
}
