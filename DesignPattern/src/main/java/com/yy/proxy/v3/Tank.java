package com.yy.proxy.v3;

import java.util.Random;

/**
 * 使用代理进行实现
 */
public class Tank implements Movable{
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankProxy(new Tank()).move();
    }
}
interface Movable{
    void move();
}