package org.yy.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * HashSet特点：唯一、无序
 * LinkedHashSet特点：唯一、有序（按照输入顺序输出）,其实就是在HashSet的基础上多了一个总的链表，将放入的元素串在一起，便于有序的遍历
 */
public class TestHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println(set.add(12));
        set.addAll(Arrays.asList(34, 56, 78, 90, 12));
        System.out.println(set.add(12));
        System.out.println(set.size());
        System.out.println(set);

        // 自定义的类型不满足唯一无序的特点
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(18,"hh"));
        students.add(new Student(80,"yy"));
        students.add(new Student(18,"hh"));
        System.out.println(students.size());
        System.out.println(students);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(12);
        linkedHashSet.addAll(Arrays.asList(34, 56, 78, 90, 12));
        System.out.println(linkedHashSet);
    }
}

class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
