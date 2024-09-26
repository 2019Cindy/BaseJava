package com.yy.factory.abstractFac;

/**
 * 抽象工厂生产三种抽象产品
 */
public abstract class AbstractFactory {
    abstract AbstractFood createFood();

    abstract AbstractTool createTool();

    abstract AbstractVehicle createVehicle();
}
