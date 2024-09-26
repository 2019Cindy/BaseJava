package com.yy.factory.abstractFac;

/**
 * 魔法世界工厂生产：蘑菇，魔法棒，扫帚
 */
public class MagicFactory extends AbstractFactory{
    @Override
    AbstractFood createFood() {
        return new MarshRoom();
    }

    @Override
    AbstractTool createTool() {
        return new MagicStick();
    }

    @Override
    AbstractVehicle createVehicle() {
        return new Broom();
    }
}
