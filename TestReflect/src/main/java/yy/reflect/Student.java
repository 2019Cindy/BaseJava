package yy.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class Student extends Person {
    private int id;
    double height;
    protected double weight;
    public double score;

    public Student() {
        System.out.println("空参构造器");
    }

    private Student(int id) {
        this.id = id;
    }

    public Student(int id, double height) {
        this.id = id;
        this.height = height;
    }

    protected Student(int id, double height, double weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }

    public String showInfo() {
        return "三好学生";
    }
    public String showInfo(int a) {
        return "有参：三好学生,"+a;
    }

    private void work() {
        System.out.println("努力找工作");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 字节码信息
        Class<Student> stuClass = Student.class;
        // 通过字节码信息获取构造器
        // getConstructors:只能获取当前运行类的public修饰的构造器
        Constructor<?>[] constructors = stuClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("================");
        // getDeclaredConstructors：获取运行时类的全部构造器
        Constructor<?>[] c2 = stuClass.getDeclaredConstructors();
        for (Constructor c : c2) {
            System.out.println(c);
        }
        System.out.println("================");
        // 获取指定的构造器
        // 没有参数，获取的为空构造器
        Constructor<Student> con1 = stuClass.getConstructor();
        System.out.println(con1);
        // 获取两个参数的有参构造器
        Constructor<Student> con2 = stuClass.getConstructor(int.class, double.class);
        System.out.println(con2);

        // 获取一个参数的构造器，并且为private修饰
        Constructor<Student> con3 = stuClass.getDeclaredConstructor(int.class);
        System.out.println(con3);

        System.out.println("======有构造器后开始创建对象========");
        Student student = con1.newInstance();
        System.out.println(student);
        System.out.println(student.showInfo());
        Student stu2 = con2.newInstance(18, 180);
        System.out.println(stu2);

        System.out.println("===========获取所有属性==============");
        // getFields 获取当前类及其父类中被public修饰的属性
        Field[] stuFields = stuClass.getFields();
        for (Field f : stuFields) {
            System.out.println(f);
        }
        System.out.println("=========");
        // getDeclaredFields 获取当前类所有属性
        Field[] fields = stuClass.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("===========获取指定属性=============");
        Field f1 = stuClass.getField("score");
//        Field f1 = stuClass.getField("weight");
        System.out.println(f1);

        Field fId = stuClass.getDeclaredField("id");
        System.out.println(fId);

        System.out.println("=========获取属性的具体信息===========");
        // 获取属性的修饰符
        int modifiers = fId.getModifiers();
        System.out.println("修饰符：" + modifiers + "，具体修饰符：" + Modifier.toString(modifiers));
        // 获取属性的数据类型
        Class<?> type = fId.getType();
        System.out.println("数据类型：" + type.getClass());
        // 获取属性的名字
        System.out.println("名字：" + fId.getName());


        System.out.println("==========给属性赋值=============");
        System.out.println(stu2);
        // 给属性设置必须要有对象，给stu2对象的id属性设值
        fId.set(stu2, 80);
        System.out.println(stu2);

        System.out.println("=========获取方法===========");
        // getMethods:获取当前类及其所有父类（当前为Person和Object）中的public方法
        Method[] methods = stuClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("=================");

        Class<? super Student> personClass = stuClass.getSuperclass();  // 获取父类的字节码信息
        Method[] m3 = personClass.getDeclaredMethods();
        for (Method m : m3) {
            System.out.println(m);
        }
        // getDeclaredMethods:获取当前类中的所有方法
        Method[] m2 = stuClass.getDeclaredMethods();
        for (Method m : m2) {
            System.out.println(m);
        }

        System.out.println("==========获取指定的方法=============");
        Method showInfo = stuClass.getMethod("showInfo");
        System.out.println(showInfo);
        Method show1 = stuClass.getMethod("showInfo", int.class);
        System.out.println(show1);
        Method work = stuClass.getDeclaredMethod("work");
        System.out.println(work);
        System.out.println("=========获取方法的具体结构===========");
        // 修饰符
        int m1 = show1.getModifiers();
        System.out.println("修饰符："+m1+",具体的修饰符："+Modifier.toString(m1));
        // 返回值类型
        Class<?> returnType = show1.getReturnType();
        System.out.println("返回值类型："+returnType);
        // 方法名
        System.out.println("方法名："+show1.getName());
        // 异常
        Class<?>[] exceptionTypes = show1.getExceptionTypes();
        System.out.println("异常："+ Arrays.toString(exceptionTypes));
        // 参数列表
        Class<?>[] parameterTypes = show1.getParameterTypes();
        System.out.println("参数列表："+ Arrays.toString(parameterTypes));

        Method main = stuClass.getMethod("main", String[].class);
        System.out.println(Arrays.toString(main.getExceptionTypes()));
        System.out.println(Arrays.toString(main.getParameterTypes()));

        System.out.println("==========调用方法============");
        work.invoke(stu2);
        System.out.println(show1.invoke(stu2, 33));

        System.out.println("========运行时类所在的包========");
        System.out.println(stuClass.getPackage());
        System.out.println("========运行类的注解=========");
        Annotation[] annotations = stuClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));
    }
}
