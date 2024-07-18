package org.yy.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestLocalDate {
    public static void main(String[] args) {
        // 1.now()
        LocalDate localDate = LocalDate.now();  // 日期
        LocalTime localTime = LocalTime.now();  // 时间
        LocalDateTime localDateTime = LocalDateTime.now();  // 日期时间
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // 2.of():设置指定的日期、时间、日期时间
        LocalDate of = LocalDate.of(2024, 6, 23);
        LocalTime of1 = LocalTime.of(22, 5);
        LocalDateTime of2 = LocalDateTime.of(2024, 6, 23, 22, 05);

        // 其他常用方法
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        // with方法，设置
        // 不会直接修改原来的localDateTime，会生成一个新的对象
        LocalDateTime localDateTime1 = localDateTime.withMonth(4);
        System.out.println(localDateTime1);

        // 提供了加减操作
        LocalDateTime localDateTime2 = localDateTime1.plusDays(3);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime1.minusMonths(2);
        System.out.println(localDateTime3);
    }
}
