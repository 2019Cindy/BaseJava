package com.yy.singleton;

public class Test03 {
    private static Test03 INSTANCE;

    private Test03() {
    }

    // synchronized加锁保证了线程安全问题，但是效率低
    public static synchronized Test03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Test03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Test03.getInstance().hashCode());
            }).start();
        }
    }
}
