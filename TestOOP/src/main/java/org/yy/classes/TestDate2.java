package org.yy.classes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * java.util.Date 和 java.sql.Date的区别：
 *  java.util.Date：年 月 日 时分秒
 *  java.sql.Date：年月日
 * 联系：
 *  java.util.Date 父类，java.sql.Date：子类
 *
 *  SimpleDateFormat实现String和date之间的转换
 */
public class TestDate2 {
    public static void main(String[] args) {
        Date d = new Date(1719135221353L);
        System.out.println(d);

        // 相互转换
        // utils--->sql
        java.util.Date date = new Date(1719135221353L);
        Date date1 = (Date) date;   // 向下转型
        Date date2 = new Date(date.getTime());  // 利用构造器
        // sql--->utils
        java.util.Date date3 = d;
        // String--->sql
        System.out.println( Date.valueOf("2024-06-23"));

        // 字符串转date
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date4 = null;
        try {
            date4 = df.parse("2024-6-23 17:59:11");
            System.out.println(date4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String date5 = df.format(new java.util.Date());
        System.out.println(date5);
    }
}
