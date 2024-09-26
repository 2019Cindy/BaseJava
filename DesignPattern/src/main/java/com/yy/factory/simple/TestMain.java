package com.yy.factory.simple;

/**
 * 任意定制交通工具：实现movable接口
 * 任意定制生产过程：xxxFactory.create()
 * 任意定制产品一族：抽象工厂模式
 */
public class TestMain {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Plan plan = new Plan();
//        plan.go();

        Movable m = new Plan(); // 多态
        m.go();

        Movable car = new CarFactory().create();
        car.go();
    }
}
