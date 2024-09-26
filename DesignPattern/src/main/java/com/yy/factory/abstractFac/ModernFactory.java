package com.yy.factory.abstractFac;

/**
 * 具体的实现工厂，继承于抽象工厂
 * 现代化工厂生产 面包，AK47，汽车
 */
public class ModernFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        return new Bread();
    }

    @Override
    AbstractTool createTool() {
        return new AK47();
    }

    @Override
    AbstractVehicle createVehicle() {
        return new Car();
    }
}
