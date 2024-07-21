package yy.enumTest;

public class Person {
    private int age;
    private String name;
    private Gender sex;

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

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "yy.enumTest.Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(18);
        p.setName("hhh");
        p.setSex(Gender.WOMAN); // 传入枚举类对象，入口对参数进行限制
        System.out.println(p);
    }
}
