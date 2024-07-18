package org.yy.exception;

/**
 * 自定义异常
 *  如果继承的是运行时异常，使用时无需额外处理
 *  如果继承的是检查异常，那么使用的时候就需要try-catch 或 throws向上抛
 */
public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}

class Student{
    int age;
    String name;
    String sex;

    public Student() {
    }

    public Student(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws MyException {
        if("男".equals(sex) || "女".equals(sex)) {
            this.sex = sex;
        }else
            throw new MyException("性别不对");
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
class Test{
    public static void main(String[] args) throws MyException {
        Student s1 = new Student(18, "娜娜", "女");
        Student s2 = new Student();
        s2.setName("Bob");
        s2.setSex("nan");
        System.out.println(s2);
    }
}
