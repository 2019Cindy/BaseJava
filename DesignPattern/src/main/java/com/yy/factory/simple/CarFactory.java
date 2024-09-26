package com.yy.factory.simple;

public class CarFactory {
    public Car create(){
        System.out.println("a car created!");
        return new Car();
    }
}
