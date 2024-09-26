package com.yy.proxy.v5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    Tank tank;
    public LogHandler(Tank tank){
        this.tank=tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start....");
        Object o = method.invoke(tank, args);
        System.out.println("end...");
        return o;
    }
}
