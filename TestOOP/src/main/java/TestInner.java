import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

/**
 * 内部类：成员内部类(静态、非静态)，局部内部类(位置：方法内、块内、构造器内)
 * 成员内部类可以是属性，方法，构造器等
 *      修饰符：private、public、protected、default、final、aabstract等
 * 内部类可以访问外部类的内容
 * 静态内部类中只能访问外部类中被static修饰的属性、方法
 *
 */
public class TestInner {
    private int age;
    class A{    // 成员内部类
        public void aa() {
            System.out.println(age);
        }
    }
    // 静态成员内部类
    static class B{

    }
    TestInner(){
        class C {

        }
    }
    public void eat(){
        class D{

        }
    }

    public static void outer(){
        System.out.println("=============外部类");
    }

    // 局部内部类
    public void method(){
        // 在局部内部类中访问到的变量必须被final修饰
        final int num=10;
        class A{
            public void a(){
//                num=20;
                System.out.println(num);
            }
        }
    }

    public Comparable method3(){
        // 匿名内部类
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
class Test{
    public static void main(String[] args) {
        // 创建静态的成员内部类对象
        TestInner.B b = new TestInner.B();
        // 创建非静态的成员内部类对象
        TestInner t = new TestInner();
        TestInner.A a = t.new A();

    }
}
