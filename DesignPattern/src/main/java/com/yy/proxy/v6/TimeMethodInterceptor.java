package com.yy.proxy.v6;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before....");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("after....");
        return result;
    }
}
