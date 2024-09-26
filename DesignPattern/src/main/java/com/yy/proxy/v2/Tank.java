package com.yy.proxy.v2;

import java.util.Random;

public class Tank implements Movable{
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
    }
}
interface Movable {
    void move();
}