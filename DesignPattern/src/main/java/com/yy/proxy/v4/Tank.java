package com.yy.proxy.v4;

import java.util.Random;

/**
 * 多种代理进行组合,将代理的对象改为Movable类型
 */
public class Tank implements Movable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}
interface Movable{
    void move();
}
