package org.yy.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * 格式化
 */
public class TestDateFormatter {
    public static void main(String[] args) {
        // 方式一：预定义的标准格式，如：ISO_LOCAL_DATE_TIME等
        DateTimeFormatter df1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // LOCAL_DATE_TIME --- > String
        LocalDateTime now = LocalDateTime.now();
        String str = df1.format(now);
        System.out.println(str);

        // String ---> LOCAL_DATE_TIME
        TemporalAccessor res = df1.parse(str);
        System.out.println(res);

        // 方式二：本地化相关格式，ofLocalizedDateTime
        DateTimeFormatter df2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        // LOCAL_DATE_TIME --- > String
        LocalDateTime now1 = LocalDateTime.now();
        String str2 = df2.format(now1);
        System.out.println(str2);
        // String ---> LOCAL_DATE_TIME
        TemporalAccessor res2 = df2.parse(str2);
        System.out.println(res2);

        // 方式三：自定义格式，ofPattern()
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String str3 = df3.format(LocalDateTime.now());
        System.out.println(str3);
        TemporalAccessor res3 = df3.parse(str3);
        System.out.println(res3);

    }

}
