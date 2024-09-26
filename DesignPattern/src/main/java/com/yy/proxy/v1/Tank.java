package com.yy.proxy.v1;

import java.util.Random;

/**
 * 记录坦克的移动时间
 * v1：记录坦克移动及结束的起止时间
 */
public class Tank implements Movable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("tank moving.....");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
    }
}

interface Movable {
    void move();
}
