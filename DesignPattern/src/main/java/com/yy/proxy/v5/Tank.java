package com.yy.proxy.v5;

import java.lang.reflect.Proxy;

/**
 * 动态代理：通过反射实现
 */
public class Tank implements Movable {
    @Override
    public void move() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        Movable o = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(tank));
        o.move();
    }
}
interface Movable{
    void move();
}
