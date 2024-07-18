package org.yy.classes;

import java.util.Date;

/**
 * 日期相关的类
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(d.toGMTString());
        System.out.println(d.toLocaleString());

        System.out.println(d.getYear()+":"+d.getMonth());

        // 一般用于衡量算法所用的时间
        System.out.println(d.getTime());
        System.out.println(System.currentTimeMillis());
    }
}
