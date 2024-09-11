package com.yy.singleton;

/**
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 类加载到内存中，不论是否用到，都实例化完成
 */
public class Test01 {
    private static final Test01 INSTANCE = new Test01();

    private Test01() {
    }


    public static Test01 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Test01 test01 = Test01.getInstance();
        Test01 test02 = Test01.getInstance();
        // true:两个是同一个对象
        System.out.println(test01 == test02);
    }
}
