package com.yy.proxy.v2;

/**
 * 通过继承的方法实现
 */
public class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
    }

    public static void main(String[] args) {
        Tank2 tank2 = new Tank2();
        tank2.move();
    }
}
