/**
 * 构造器
 *  1.一般保证空构造器的存在，空构造器中一般不会进行属性的赋值操作
 *  2.一般会重载构造器，在重载的构造器中进行属性的赋值操作
 *  3.在重载构造器以后，如果空构造器忘写了，系统不会分配默认的空构造器了，若调用空构造器就会报错
 *  4.当形参名和属性名重名时，就会出现就近原则，在要表示对象的属性前加上this.来修饰，因为this代表的就是创建的对象
 */
public class PersonConstructor {
    String name;
    int age;
    double height;

    /**
     * 构造器和方法的区别：
     * 1.没有方法的返回值类型
     * 2.方法体内部不能有return
     * 3.构造器的名字很特殊，必须和类名保持一致
     */
    // 无参构造器
    public PersonConstructor() {
    }

    public PersonConstructor(int age, String name) {
        this.age = age;
        this.name = name;
    }
    /**
     * 构造器的作用：不是为了创建对象，因为在调用构造器之前，对象已经被创建好了，并且属性有默认的初始化值
     * 调用构造器的目的是给属性进行赋值操作
     *
     * @param age
     * @param name
     * @param height
     */
    public PersonConstructor(int age, String name, double height) {
        // 就近原则，在要表示对象的属性前加上this.修饰，因为this代表的就是创建的那个对象
//        this.age = age;
//        this.name = name;
        this(age,name);     // this 可以修饰构造器：同一个类中构造器可以相互用this调用，注意：this修饰构造器必须放在第一行，
        this.height = height;
    }

    public static void main(String[] args) {
        /** new 关键字实际上是在调用一个方法，这个方法叫构造方法
         *  调用构造器的时候，如果你的类中没有写构造器，那么系统会默认给你分配一个构造器，只是看不到罢了
         *   但可以自己显示的将构造器编写出来
         *  构造器格式：[修饰符] 构造器的名字(){}
         */

        PersonConstructor p = new PersonConstructor();
        PersonConstructor p2 = new PersonConstructor(18, "hhh", 180.5);
    }
}
