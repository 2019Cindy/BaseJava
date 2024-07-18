/**
 * 局部变量与成员变量的区别
 * 1.位置不同：
 *      成员变量：类中方法外定义的变量
 *      局部变量：方法中定义的变量
 * 2.作用范围：
 *      成员变量：丹茜蕾的很多方法
 *      局部变量：当前一个方法
 * 3.是否有默认值：
 *      成员变量：有
 *      局部变量：无
 * 4.是否需要初始化：
 *      成员变量：不需要，不建议初始化
 *      局部变量：一定呀初始化，不然使用时直接报错
 * 5.内存中位置不同
 *      成员变量：堆内存
 *      局部变量：栈内存
 * 6.作用时间不同
 *      成员变量：当前对象从创建到销毁
 *      局部变量：当前方法从开始执行到执行完毕
 */
public class Student {
    int age;   // 成员变量，在类中方法外
    String name;

    public void study() {
        int num = 10;    // 局部变量，在方法中
        System.out.println(num);
        System.out.println(name);
    }

    public void eat() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.name);
    }
}
