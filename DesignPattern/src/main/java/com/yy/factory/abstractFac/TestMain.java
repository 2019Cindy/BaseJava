package com.yy.factory.abstractFac;

/**
 * 任意定制产品一族：抽象工厂模式
 */
public class TestMain {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();
        AK47 tool = new AK47();
        tool.shoot();
        Bread bread = new Bread();
        bread.printName();
        System.out.println("==========================");

//        ModernFactory f = new ModernFactory();    // 现代社会
        MagicFactory f = new MagicFactory();    // 魔法世界
        AbstractVehicle car1 = f.createVehicle();
        AbstractTool tool1 = f.createTool();
        AbstractFood food1 = f.createFood();
        car1.go();
        tool1.shoot();
        food1.printName();
    }
}
