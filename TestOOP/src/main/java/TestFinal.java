/**
 * final修饰符：
 * 修饰变量：
 *  修饰一个变量，变量的值不可以改变，即这个变量也就变成了字符常量，约定俗成的规定--名字大写
 *  修饰引用数据类型，那么地址值就不可以改变
 * 修饰方法：final修饰方法，该方法不可以被子类重写
 * 修饰类：final修饰类，该类不可以被继承，即没有子类
 *
 */
public class TestFinal {
    public static void main(String[] args) {
        final int A = 10;
        final Dog dog = new Dog();
        a(dog);
    }

    public static void a(Dog d) {
        d = new Dog();
        System.out.println("========");
    }

    public static void b(final Dog d){
//        d=new Dog();Dog
    }
}

class Dog {
    String name;

    public Dog() {
    }
}
