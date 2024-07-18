/**
 * 继承关系：
 * 继承的好处：
 *      1.提高代码的复用性
 *      2.便于代码的扩展
 *      3.为了多态使用，是多态的前提
 *      4.一个父类可以有多个子类，一个子类只能有一个直接父，但可以间接的继承自其他类
 *      5.继承具有传递性：Student---->继承自Person------>继承自Object
 *
 * 权限修饰符：
 *      private:在当前类中可以访问
 *      default:权限最大到同一个包下的其他类都可以访问
 *      protected:权限最大到不同包下的子类
 *      public:在整个项目中都可以访问
 *
 * 方法的重写：
 *  重写：发生在子类和父类中，当子类对父类的方法不满意的时候，要对父类的方法进行重写
 *  有严格的格式要求：子类的方法名和父类必须一致，参数列表的个数，类型，顺序得一致
 *  注意：父类的权限修饰符要低于子类的，父类的返回值类型要大于子类的
 *
 * 重载与重写的区别：
 *  重载：在同一个类中，当方法名相同，形参列表不同时，多个方法构成了重载
 *  重写：在不同的类中，子类对父类提供的方法不满意时，要对父类的方法进行重写
 *
 * super修饰符：可以修饰属性，也可以修饰方法
 *  在子类的方法中，可以通过super.属性 super.方法的方式，显示的调用父类提供的属性 方法，通常情况下super.可以省略不写
 *  在特殊情况下，当子类和父类的属性重名时，若想要使用父类的属性，必须加上super修饰符
 * super修饰构造器：
 *  在构造器中，super调用父类的构造器和this调用子类的构造器只能存在一个，不能共存，因为super修饰构造器得放第一行，this修饰构造器也得放第一行
 *
 */
public class TestExtendPeople {
    private int age = 10;
    private String name;
    private float height;

    TestExtendPeople() {

    }

    TestExtendPeople(int age, String name) {
        this.age = age;
        this.name = name;
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void eat() {
        System.out.println("=========吃饭");
    }

    public void sleep() {
        System.out.println("=========睡觉");
    }

    public static void main(String[] args) {
        TestExtendStudent s = new TestExtendStudent();
        s.setCid(1001);
        s.setAge(18);
        s.setName("Cindy");
        System.out.println("学生信息=====学号：" + s.getCid() + "姓名：" + s.getName() + "年龄：" + s.getAge());
        s.eat();
        s.a();
    }
}
