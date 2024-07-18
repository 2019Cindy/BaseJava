package org.yy.collection.set;

import java.util.Comparator;

/**
 * 比较器
 *  内部比较器和外部比较器：
 *  外部比较器较好：利用多态的特性，扩展性好
 */
public class TestCompareTo {
    public static void main(String[] args) {
        int i1 = 12;
        int i2 = 22;
        System.out.println(i1 - i2);
        String s1 = "aa";
        String s2 = "BB";
        System.out.println(s1.compareTo(s2));

        // 内部比较器
        StudentTest stu1 = new StudentTest(18, "hh");
        StudentTest stu2 = new StudentTest(8, "aa");
        System.out.println(stu1.compareTo(stu2));

        // 外部比较器
        OuterComparator comparator = new OuterComparator();
        System.out.println(comparator.compare(stu1, stu2));
        OuterComparator1 comparator1 = new OuterComparator1();
        System.out.println(comparator1.compare(stu1, stu2));
    }
}

// 内部比较器，实现Comparable接口，重写compareTo方法
class StudentTest implements Comparable<StudentTest> {
    private int age;
    private String name;

    public StudentTest(int age, String name) {
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
    public int compareTo(StudentTest o) {
//        return this.getAge() - o.getAge();
        return this.getName().compareTo(o.getName());
    }
}

// 外部比较器
class OuterComparator implements Comparator<StudentTest> {

    @Override
    public int compare(StudentTest o1, StudentTest o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class OuterComparator1 implements Comparator<StudentTest> {

    @Override
    public int compare(StudentTest o1, StudentTest o2) {
        return o1.getAge()-o2.getAge();
    }
}