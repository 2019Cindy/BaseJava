package com.yy.proxy.v4;

public class TankTimeProxy implements Movable{
    Movable m;
    public TankTimeProxy(Movable m){
        this.m=m;
    }
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }
}
