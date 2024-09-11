package com.yy.singleton;

/**
 * 懒加载
 * 达到了按需初始化的目的，但是导致线程不安全的问题
 */
public class Test02 {
    private static Test02 INSTANCE;

    private Test02() {
    }

    public static Test02 getInstance() {
        if (INSTANCE == null) { // 线程不安全，会实例化多个对象
            INSTANCE = new Test02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Test02.getInstance().hashCode());
            }).start();
        }
    }
}
