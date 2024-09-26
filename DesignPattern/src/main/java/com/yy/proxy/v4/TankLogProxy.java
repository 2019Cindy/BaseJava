package com.yy.proxy.v4;

public class TankLogProxy implements Movable{
    Movable m;
    public TankLogProxy(Movable m){
        this.m=m;
    }
    @Override
    public void move() {
        System.out.println("start.....");
        m.move();
        System.out.println("end....");
    }
}
