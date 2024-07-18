import java.util.Objects;

/**
 * Object 的toString方法
 * equals方法：提供了对对象内容是否相等的一个比较方式，即属性
 *      父类提供的equals方法就是比较==地址，没有实际意义，一般子类会对这个方法进行重写
 */
public class TestObjectFunc {
    public static void main(String[] args) {
        Student1 s = new Student1(18, "Jame", 180.9);
        System.out.println(s);
        System.out.println(s.toString());
        Student1 s2 = new Student1(18, "Jame", 180.9);
        // ==的作用，比较左右两侧的值是否相等，对引用数据来说比较的是地址值
        System.out.println(s == s2);
        // Object 类提供了一个equals方法，比较对象具体内容是否相等，底层依旧调用==比较地址值
        System.out.println(s.equals(s2));
    }
}

class Student1 {
    private int age;
    private String name;
    private double height;

    public Student1() {

    }

    public Student1(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return age == student1.age &&
                Double.compare(student1.height, height) == 0 &&
                Objects.equals(name, student1.name);
    }

}
