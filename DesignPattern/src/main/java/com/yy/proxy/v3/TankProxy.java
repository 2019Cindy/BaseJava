package com.yy.proxy.v3;

public class TankProxy implements Movable {
    Tank tank;

    public TankProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start...");
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("end....");
        System.out.println("耗时：" + (end - start));
    }
}
