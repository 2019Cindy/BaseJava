package yy.reflect;

import java.lang.reflect.InvocationTargetException;

public class Person {
    private int age;
    public String name;

    public void eat(){
        System.out.println("person ... eat");
    }
    public void sleep(){
        System.out.println("person... sleep");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 获取字节码信息的四种方法
        // 方法1：通过getClass()获取
        Person p = new Person();
        Class<? extends Person> pClass = p.getClass();
        System.out.println(pClass);

        // 方式2：通过内置class属性，方式1 2 不常用，因为都一直person类了，可以直接操作
        System.out.println(Person.class);

        // 方式3：用的最多，调用class类提供的静态方法forname
        Class<?> c1 = Class.forName("yy.reflect.Person");
        System.out.println(c1==pClass);

        // 方式4：类的加载器，了解即可
        ClassLoader loader = Person.class.getClassLoader();
        Class<?> c2 = loader.loadClass("yy.reflect.Person");
        System.out.println(c2==pClass);
    }
}
