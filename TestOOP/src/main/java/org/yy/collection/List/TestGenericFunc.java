package org.yy.collection.List;

/**
 * 1.泛型方法：
 *  不是带泛型的方法就是泛型方法，泛型方法的要求：这个方法的泛型的参数类型和当前的类的泛型无关
 * 2.泛型方法定义的时候，前面要加上<T>
 *      如果不加的话，会把T当作一种数据类型，然而代码中没有T类型就会报错
 * 3.T的类型是在调用方法的时候确定的
 * 4.泛型方法可以是静态方法
 */
public class TestGenericFunc<E> {
    // 不是泛型方法
    public void a(E e) {

    }

    // 是泛型方法
    public static  <T> void b(T t) {

    }

    public static void main(String[] args) {
        TestGenericFunc<String> g = new TestGenericFunc<>();
        g.a("aaa");
        g.b(111);
    }
}
