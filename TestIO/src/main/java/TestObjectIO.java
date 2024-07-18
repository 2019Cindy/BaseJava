import java.io.*;

/**
 * 对象流：
 * 序列化：
 *  被序列化的类的内部所有属性，必须是可序列化的（基本数据类型都是可序列化的）
 *  static transient修饰的属性 不可以被序列化
 */
public class TestObjectIO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 字符串对象写到文件中去（二进制文件）:序列化
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("F:\\objectIO.txt")));
//        out.writeObject("哈哈啥");
//        out.close();
//
//        // 写一个程序读文件中内容:反序列化
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("F:\\objectIO.txt")));
//        System.out.println(in.readObject());

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("F:\\objectIO.txt")));
        out.writeObject(new Person(18,"哈哈哈"));
        out.writeObject(new Person(34,"啊啊啊"));

        out.writeObject(new Person(56,"嗷嗷嗷嗷"));

        // 将二进制数据读入到程序中
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("F:\\objectIO.txt")));
        Person p1=(Person) in.readObject();
        System.out.println(p1.toString());
        Person p2 = (Person) in.readObject();
        System.out.println(p2.getAge());
        Person p3 = (Person) in.readObject();
        System.out.println(p3.getName());
    }
}

// 自定义对象，需要实现 Serializable 接口
class Person implements Serializable {
    public static final long serialVersionUID=123L;
    public int age;
    public String name;

    public Person(int age, String name) {
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
