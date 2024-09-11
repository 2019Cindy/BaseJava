package com.yy.singleton;

/**
 * 静态内部类
 */
public class Test05 {
    private Test05(){}
    private static class Test05Holder{
        private static final Test05 INSTANCE = new Test05();
    }
    public static Test05 getInstance(){
        return Test05Holder.INSTANCE;
    }

}
