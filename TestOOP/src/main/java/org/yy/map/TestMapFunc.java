package org.yy.map;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.security.KeyStore;
import java.util.*;

/**
 * map常用方法：
 * 增：put putAll
 * 删：clear remove
 * 改：
 * 查：entrySet keySet get size values
 * 判断：containsValue containsKey equals isEmpty
 *
 * HashMap 特点：
 *  无序、唯一，按照key进行总结，因为底层key遵照哈希表的结构（数组+链表）
 *  Hash表原理：放入这个集合的数据对应的那个类，必须重写hashCode和equals方法
 * LinkedHashMap特点：唯一、有序（按照输入顺序进行输出）
 * TreeMap特点：唯一、有序（按照key的升序或者降序）
 * 原理：二叉树，key遵照二叉树的特点，放入集合的key的数据对应的类型，内部一定要实现比较器
 *
 */
public class TestMapFunc {
    public static void main(String[] args) {
        // hashMap 特点：无序、唯一
        Map<String,Integer> map = new HashMap<>();
        Map<String, Integer> m = new HashMap<>();
        m.put("hhh", 111);
        m.put("ttt", 222);
        map.put("aa", 111);
        map.put("bb", 222);
        map.putAll(m);
        System.out.println(map.size());
        System.out.println(map);

//        map.clear();
//        System.out.println(map.size());
//        System.out.println(map.remove("hhh"));
        System.out.println(map);
        System.out.println(map.containsKey("aa"));
        System.out.println(map.containsValue(222));

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("aa", 111);
        map2.put("bb", 222);
        map2.putAll(m);
        System.out.println(map == map2);
        System.out.println(map.equals(map2));   // equals进行重写，比较的是具体的值

        System.out.println(map.isEmpty());

        System.out.println(map.get("aa"));

        // 对集合中的key进行遍历
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println("for:" + map.get(s));
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + "=========" + map.get(next));
        }

        // 对集合中的value进行遍历
        Collection<Integer> values = map.values();
        for (Integer i : values) {
            System.out.println("forEach:" + i);
        }
        Iterator<Integer> iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            System.out.println("value:" + iterator1.next());
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        Iterator<Map.Entry<String, Integer>> iterator2 = entries.iterator();
        while (iterator2.hasNext()){
            Map.Entry<String, Integer> next = iterator2.next();
            System.out.println("Iterator entry  "+next.getKey()+":"+next.getValue());
        }

        //
        System.out.println("=======================");
        // LinkedHashMap特点：唯一、有序（按照输入顺序进行输出）
//        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a",9090);
        map1.put("b",7878);
        map1.putAll(m);
        System.out.println(map1);

        System.out.println("=======treemap========");
        Map<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("b",9090);
        treeMap.put("a",1212);
        treeMap.put("d",5656);
        treeMap.put("c",7878);
        System.out.println(treeMap);

        // 自定义数据类型
//        TreeMap<Student, Integer> treeMap1 = new TreeMap<>();
        TreeMap<Student, Integer> treeMap1 = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        treeMap1.put(new Student(19,"haha"),1212);
        treeMap1.put(new Student(34,"ttt"),3434);
        treeMap1.put(new Student(12,"aaa"),5656);
        System.out.println(treeMap1);

        // 外部比较器
        OuterComparator outerComparator = new OuterComparator();

    }
}
class Student implements Comparable<Student>{ //
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
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
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

// 外部比较器
class OuterComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}