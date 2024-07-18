/**
 * static 可以修饰属性、方法、代码块、内部类
 * static修饰属性：
 *  1.在类加载的时候一起加载入方法去中的静态域
 *  2.先于对象存在
 *  3.访问方式：对象名.属性名  类名.属性名
 *
 *  static修饰属性的应用场景：某些特定的数据想要在内存中共享，只有一块区域，可以用static修饰
 *
 * static修饰方法：
 *  1.static和public都是修饰符。没有先后顺序
 *  2.在静态方法中不能访问非静态的方法
 *  3.静态方法中不能访问非静态的方法
 *  4.静态方法中不能使用this关键字
 *  5.非静态的方法可以通过对象名.方法名调用
 *  6.静态方法中可以用 对象名.方法名调用，也可以用类名.方法名
 */
public class TestStatic {
    int id;
    static int cid;

    public static void main(String[] args) {
        TestStatic.cid = 200;
        TestStatic t = new TestStatic();
        t.id = 10;
        t.cid = 10;

        TestStatic t1 = new TestStatic();
        t1.id = 20;
        t1.cid = 20;

        TestStatic t2 = new TestStatic();
        t2.id = 30;
        t2.cid = 30;

        System.out.println(t.id);
        System.out.println(t1.id);
        System.out.println(t2.id);

        System.out.println("=================");

        System.out.println(t.cid);
        System.out.println(t1.cid);
        System.out.println(t2.cid);

        new TestStatic().a();
        TestStatic.b(); // 静态方法中可以用 对象名.方法名调用，也可以用类名.方法名
    }

    public void a(){
        System.out.println(id);
        System.out.println(cid);
        System.out.println("===========a");
    }

    public static void b(){
//        System.out.println(this.id);
        System.out.println(cid);
        System.out.println("===========b");
    }
}
