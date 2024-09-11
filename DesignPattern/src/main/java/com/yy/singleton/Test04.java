package com.yy.singleton;

public class Test04 {
    private static Test04 INSTANCE;

    private Test04() {
    }

    public static Test04 getInstance() {
        if (INSTANCE == null) {
            // 双重检查，判断实力对象是否为空，然后再上锁
            synchronized (Test04.class) {
                INSTANCE = new Test04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Test04.getInstance().hashCode());
            }).start();
        }
    }
}
