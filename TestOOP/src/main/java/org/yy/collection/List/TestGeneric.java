package org.yy.collection.List;

/**
 * 泛型类
 * <>里面就是一个参数类型，这个类型现在是不确定的，相当于一个占位符
 * 但是确定的是这个类型一定是一个引用数据类型，而不是基本数据类型
 */
public class TestGeneric<E> {
    int age;
    String name;
    E sex;
    public void a(E n){

    }
    public void b(E[] n){

    }
}
// 继承的父类指定泛型
class SubGeneric extends TestGeneric<Integer>{}

// 继承的父类不指定泛型
class SubGeneric2<E> extends TestGeneric<E>{}
class Test{
    public static void main(String[] args) {
        // 实例化的时候不指定泛型：如果实例化的时候不明确的指定类的泛型，那么认位此泛型为Object类型
        TestGeneric generic = new TestGeneric();
        generic.a("abc");
        generic.b(new String[]{"aaa"});

        // 实例化的时候指定泛型
        TestGeneric<String> generic1 = new TestGeneric<>();
        generic1.sex="男";
        generic1.a("aaa");
        generic1.b(new String[]{"as","bc"});

        // 指定父类泛型，那么子类就不需要在指定泛型了，可以直接使用
        SubGeneric subGeneric = new SubGeneric();
        subGeneric.a(111);

        // 父类不指定泛型，那么子类也会变成一个泛型类，这个E的类型可以在创建子类对象的时候确定
        SubGeneric2<String> subGeneric2 = new SubGeneric2<>();
        subGeneric2.a("yyy");
    }
}
