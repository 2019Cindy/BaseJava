package com.yy.factory.simple;

/**
 * 简单工厂模式:创建对象的类
 * 缺点：扩展性不好
 */
public class SimpleFactory {
    public Car carFactory() {
        return new Car();
    }

    public Plan planFactory() {
        return new Plan();
    }
}
