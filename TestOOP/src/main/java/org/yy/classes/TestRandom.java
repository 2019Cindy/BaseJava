package org.yy.classes;

import java.util.Random;

/**
 * 随机数
 */
public class TestRandom {
    public static void main(String[] args) {
        // 利用带参数的构造器，seed一样，生成的随机数也就一样
        Random random = new Random(10000l);
        int i = random.nextInt();
        System.out.println(i);

        // 利用空参构造器创建对象
        Random r2 = new Random();
        // 生成0到指定区间的随机数
        int i2 = r2.nextInt(10);
        System.out.println(i2);
        System.out.println(r2.nextDouble());

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
