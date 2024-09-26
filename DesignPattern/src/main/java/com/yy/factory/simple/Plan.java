package com.yy.factory.simple;

public class Plan implements Movable{
    @Override
    public void go() {
        System.out.println("plan fly ....");
    }
}
