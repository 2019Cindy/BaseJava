package org.yy.classes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalendar {
    public static void main(String[] args) {
        // Calendar 抽象类，不可以直接创建对象
        Calendar cal = new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance();

        // 常用方法
        // get()传入的参数为Calendar中定义的变量
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));

        // 获取当月中最大的天数
        System.out.println(cal.getActualMaximum(Calendar.DATE));

        // set方法:可以修改Calendar中的内容
        cal.set(Calendar.YEAR,2019);
        cal.set(Calendar.MONTH,4);
        cal.set(Calendar.DATE,18);
        System.out.println(cal);
    }
}

class Exercise{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要查询的日期：");
        Date date = Date.valueOf("2024-9-5"/*sc.next()*/);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
//        System.out.println(cal);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int maxDay = cal.getActualMaximum(Calendar.DATE);
        int day = cal.get(Calendar.DATE);   // 获取当前天
        int offset = cal.get(Calendar.DAY_OF_WEEK); // 获取这个月一号本周星期几
        System.out.println(offset);
        for (int i = 1; i <= maxDay+offset-1; i++) {
            if(i<offset-1)
                System.out.print("\t");
            else {
                if (i == day+offset-1)
                    System.out.print(i-offset + 1 + "*" + "\t");
                else
                    System.out.print(i - offset + 1 + "\t");
                if (i % 7 == 0)
                    System.out.println();
            }
        }
    }
}
